package 线程的使用方式;

public class MyThread extends Thread{

    @Override
    public void run() {
        //书写线程要执行代码
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "HelloWorld");
        }
    }
}
