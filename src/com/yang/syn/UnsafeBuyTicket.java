package com.yang.syn;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station=new BuyTicket();
        new Thread(station,"我").start();
        new Thread(station,"你").start();
        new Thread(station,"黄牛").start();
    }

}
class BuyTicket implements Runnable{
    //票
    private int ticket=10;
    private boolean flag=true;
    @Override
    public void run() {
    while (flag){
        try {
            buy();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
    //同步方法，锁的是this
    public synchronized void buy() throws InterruptedException {
        if(ticket<=0){
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到第"+ticket--+"票");
    }
}
