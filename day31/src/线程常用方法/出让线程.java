package 线程常用方法;

public class 出让线程 extends Thread{

    @Override
    public void run() {//"飞机"  "坦克"
        for (int i = 1; i <= 100; i++) {

            System.out.println(getName() + "@" + i);
            //表示出让当前CPU的执行权
            Thread.yield();
        }
    }
}
