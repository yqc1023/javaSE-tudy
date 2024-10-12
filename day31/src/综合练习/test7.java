package 综合练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;

public class test7 implements Callable<Integer> {
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);
    }



    @Override
    public Integer call() {
        ArrayList<Integer> boxlist=new ArrayList<>();
        while (true) {
            synchronized (test7.class) {
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
       if (boxlist.isEmpty()){
           return null;
       }
       else {
           Integer max = Collections.max(boxlist);
           return max;
       }

    }
}
