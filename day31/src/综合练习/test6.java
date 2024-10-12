package 综合练习;

import java.util.ArrayList;
import java.util.Collections;

public class test6 implements Runnable {
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);
    }



    @Override
    public void run() {
        ArrayList<Integer> boxlist=new ArrayList<>();
        while (true) {
            synchronized (test6.class) {
                if (list.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + boxlist);
                    break;
                } else {
                    Collections.shuffle(list);
                    int remove = list.remove(0);
                    boxlist.add(remove);
                }
            }
        }
    }
}
