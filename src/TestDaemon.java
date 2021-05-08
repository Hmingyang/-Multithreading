public class TestDaemon{
    public static void main(String[] args) {
        God god=new God();
        you you=new you();
        Thread thread=new Thread(god);
        thread.setDaemon(true);
        thread.start();
        new Thread(you).start();
    }
}
class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("god bless you");
        }
    }
}
class you implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<36500;i++){
            System.out.println("开心的活着");
        }
        System.out.println("=====goodbye! world=====");
    }
}