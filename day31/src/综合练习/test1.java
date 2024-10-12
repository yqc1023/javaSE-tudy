package 综合练习;

public class test1 implements Runnable {
    static int ticket = 1;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            if (extracted()) break;
        }
    }

    private boolean extracted() {
        synchronized (obj) {
            if (ticket > 100) {
                return true;
            } else {
                System.out.println(Thread.currentThread().getName() + "出售了第" + ticket + "张票");
                ticket++;
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
