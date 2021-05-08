//注意，线程开启不一定立即执行，由CPU调度执行
//继承Thread类，重写run()方法，调用start开启线程
public class TestThread1 extends Thread {
    public void run()
    {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("代码" + i);
        }
    }


    public static void main(String[] args) {
        //main主线程
        TestThread1 test = new TestThread1();
        test.start();

        for(int i=0;i<200;i++){
        System.out.println("学习");
        }
    }

}