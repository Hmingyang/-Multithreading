//静态代理模式
//真实对象和代理对象都要实现同一接口
//代理对象必须为真实角色
//代理对象可以做很多真实对象做不了的事情
//真实对象只做自己的事情
public class Static_Proxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany=new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}
interface Marry{
    void HappyMarry();

}
//真实角色
class  You implements Marry{
    @Override
    public void HappyMarry(){
        System.out.println("结婚");
    }
}
//代理角色,帮助你结婚
class  WeddingCompany implements Marry{
    private Marry target;
    public WeddingCompany(Marry target) {
        this.target=target;
    }

    @Override
    public void HappyMarry() {
        before();
    this.target.HappyMarry();//代理对象实现
    after();
    }

    private void after() {
        System.out.println("结婚收钱");
    }

    private void before() {
        System.out.println("结婚布置现场");
    }
}
