package 线程常用方法;

public class 守护线程1 extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + "@" + i);
        }
    }
}
