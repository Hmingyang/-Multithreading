public class TestStop implements Runnable{
    private boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while(flag){
            System.out.println("run......"+i++);
        }
    }
    //设置标志位
    public void stop(){
        this.flag=false;
    }
    //测试stop
    //建议线程正常停止，不建议死循环
    //不要使用stop或者destroy
    public static void main(String[] args) {
        TestStop t=new TestStop();
        new Thread(t).start();
        for(int i=0;i<10000;i++){
            if(i==5000){
                t.stop();
                System.out.println("the progress is stop");
            }
        }
    }
}
