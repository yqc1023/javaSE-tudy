package 综合练习;

public class Test4Demo {
    public static void main(String[] args) {
        /*
            微信中的抢红包也用到了多线程。
            假设：100块，分成了3个包，现在有5个人去抢。
            其中，红包是共享数据。
            5个人是5条线程。
            打印结果如下：
            	XXX抢到了XXX元
            	XXX抢到了XXX元
            	XXX抢到了XXX元
            	XXX没抢到
            	XXX没抢到
        */
        test4 test4 = new test4();
        Thread t1=new Thread(test4,"窗口1");
        Thread t2=new Thread(test4,"窗口2");
        Thread t3=new Thread(test4,"窗口3");
        Thread t4=new Thread(test4,"窗口4");
        Thread t5=new Thread(test4,"窗口5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
