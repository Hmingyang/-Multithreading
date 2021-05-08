public class TestThread4 implements Runnable{
    private int ticketNums =100;
    @Override
    public void run() {
        while (ticketNums>2){
            try {
                //模拟延时
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"------拿到了第"+ticketNums--+"张票");//Thread.currentThread().getName()获取当前线程的名字
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket=new TestThread4();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛党").start();
    }
}
