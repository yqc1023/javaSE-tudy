package 综合练习;

public class test3 implements Runnable {

    static int number = 1;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (number > 100) {
                    break;
                } else {
                    if (number % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "获取到奇数:" + number);
                    }
                    number++;
                }
            }
        }
    }


}
