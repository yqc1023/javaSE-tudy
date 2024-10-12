package 综合练习;

public class Test1Demo {
    public static void main(String[] args) {
        test1 test1=new test1();
        Thread t1=new Thread(test1,"窗口1");
        Thread t2=new Thread(test1,"窗口2");
        t2.start();
        t1.start();
    }
}
