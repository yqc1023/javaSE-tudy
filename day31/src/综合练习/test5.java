package 综合练习;

import java.util.ArrayList;
import java.util.Collections;

public class test5 implements Runnable{
   static ArrayList<Integer> list=new ArrayList<>();
    static {
        Collections.addAll(list,10,5,20,50,100,200,500,800,2,80,300,700);
    }
    Object obj=new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if (list.size()==0){
                    break;
                }
                else {
                    Collections.shuffle(list);
                    System.out.println(Thread.currentThread().getName()+"又产生了一个"+list.get(0)+"元的大奖");
                    list.remove(0);
                }
            }
        }
    }
}
