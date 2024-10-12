package 综合练习;

public class Test3Demo {
    public static void main(String[] args) {
        test3 test3=new test3();
        Thread t1=new Thread(test3,"窗口1");
        Thread t2=new Thread(test3,"窗口2");
        t2.start();
        t1.start();
    }
}
