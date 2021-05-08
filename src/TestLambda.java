public class TestLambda {
    public static void main(String[] args) {
        ILike like=new Like();
        like.lambda();

    //局部内部类
        class Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("内部类");
            }
        }
        like=new Like3();
        like.lambda();
        //匿名内部类，没有类的名称,必须借助接口或者父类,重写方法
        like=new ILike() {
            @Override
            public void lambda() {
                System.out.println("匿名");
            }
        };
        like.lambda();
        //用lambda简化
        like=()-> {
            System.out.println("lambda");
        };
        like.lambda();
    }
    //定义一个函数式接口

}
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}

interface ILike{
    void lambda();
}