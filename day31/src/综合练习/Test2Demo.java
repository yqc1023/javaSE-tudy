package 综合练习;

public class Test2Demo {
    public static void main(String[] args) {
        test2 test2=new test2();
        Thread t1=new Thread(test2,"窗口1");
        Thread t2=new Thread(test2,"窗口2");
        t2.start();
        t1.start();
    }
}
