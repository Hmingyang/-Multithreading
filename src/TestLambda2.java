public class TestLambda2 {
    public static void main(String[] args) {
    LoveEve  love=a-> System.out.println("a:"+a);
    love.love(520);
    //总结：
        //lambda表达式只有一行才能简化为一行。否则要用代码块
        //前提是接口为函数式接口
        //多个参数可以去掉类型，要去掉都去掉，多个参数需要有括号
    }

}
interface LoveEve{
    void love(int a);
}
