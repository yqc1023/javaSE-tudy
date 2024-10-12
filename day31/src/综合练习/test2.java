package 综合练习;

public class test2 implements Runnable {

    static int gifts = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            if (extracted()) break;
        }
    }

    private boolean extracted() {
        synchronized (obj) {
            if (gifts < 10) {
                return true;
            } else {
                gifts--;
                System.out.println(Thread.currentThread().getName() + "送出了一份礼物,还剩" + gifts + "份");
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
