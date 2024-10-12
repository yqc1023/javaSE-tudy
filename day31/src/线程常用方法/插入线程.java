package 线程常用方法;

public class 插入线程 extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getName() + "@" + i);

        }
    }
}
