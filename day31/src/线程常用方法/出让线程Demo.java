package 线程常用方法;

public class 出让线程Demo {
    public static void main(String[] args) {
       /*
            public static void yield()      出让线程/礼让线程

       */

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("飞机");
        t2.setName("坦克");

        t1.start();
        t2.start();


    }
}
