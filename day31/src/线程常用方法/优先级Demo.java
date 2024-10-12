package 线程常用方法;

public class 优先级Demo {
    public static void main(String[] args){
       /*
            setPriority(int newPriority)        设置线程的优先级
            final int getPriority()             获取线程的优先级
       */

        //创建线程要执行的参数对象
        优先级 mr = new 优先级();
        //创建线程对象
        Thread t1 = new Thread(mr,"飞机");
        Thread t2 = new Thread(mr,"坦克");

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();



    }
}
