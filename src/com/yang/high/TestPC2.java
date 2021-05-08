package com.yang.high;
//测试生产者消费者问题 2：信号灯法，标志位解决
public class TestPC2 {
    public static void main(String[] args) {
        TV tv=new TV();
        Player player=new Player(tv);
        Watcher watcher=new Watcher(tv);
        player.start();
        watcher.start();
    }
}
//演员
class Player extends Thread{
TV tv;
public Player(TV tv){
    this.tv=tv;
}
@Override
public  void run(){
    for (int i = 0; i <50; i++) {
        if(i%2==0){
            this.tv.play("NBA播放中");
        }
        else{
            this.tv.play("LOL播放中");
        }
    }
}
}
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv=tv;
    }
    @Override
    public  void run(){
        for (int i = 0; i <50; i++) {
            tv.watch();
        }
    }
}
class TV{
    //演员表演，观众等待
    //观众观看，演员等待
    String peformance;
    boolean flag=true;
    public synchronized void play(String peformance){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了"+peformance);
        //通知观众观看
        this.notifyAll();
        this.peformance=peformance;
        this.flag=!this.flag;
    }
    //观看
    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了:"+peformance);
        this.notifyAll();
        this.flag=!this.flag;
    }
}
