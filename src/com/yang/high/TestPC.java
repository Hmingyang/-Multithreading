package com.yang.high;
//测试：生产者消费者模型-->利用缓冲区解决：管程法
public class TestPC {
    public static void main(String[] args) {
        Syncontainer syncontainer=new Syncontainer();
        new Productor(syncontainer).start();
        new Consumer(syncontainer).start();
    }
}

//生产者
class Productor extends Thread{
    Syncontainer syncontainer;
    public  Productor(Syncontainer syncontainer){
        this.syncontainer=syncontainer;
    }
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            syncontainer.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
//消费者
class Consumer extends Thread{
    Syncontainer syncontainer;
    public  Consumer(Syncontainer syncontainer){
        this.syncontainer=syncontainer;
    }
        @Override
        public void run(){
        for(int i=0;i<100;i++){
            System.out.println("消费了第"+syncontainer.pop().id+"只鸡");
        }
    }
}

//产品
class Chicken{
    public int id;

    public Chicken(int id) {
        this.id = id;
    }
}



//缓冲区
class Syncontainer {
    //需要一个容器大小
    Chicken[] chickens = new Chicken[100];
    //容器计数器
    int count=0;
    //生产者放入产品
    public synchronized void push(Chicken chicken) {
        //如果没有满，我们就需要丢入产品
        if(count==chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count++]=chicken;
        //可以通知消费者消费了
        this.notifyAll();
    }
    public synchronized Chicken pop(){
        //判断能否消费
        if(count==0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken=chickens[count];
        //吃完了通知生产者生产
        this.notifyAll();
        this.notify();
        return chicken;
    }

}