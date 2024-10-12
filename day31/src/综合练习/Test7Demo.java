package 综合练习;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test7Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池中的奖项为 {10,5,20,50,100,200,500,800,2,80,300,700};
        创建两个抽奖箱(线程)设置线程名称分别为    "抽奖箱1", "抽奖箱2"
        随机从抽奖池中获取奖项元素并打印在控制台上,格式如下:

        在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：10,20,100,500,2,300
        最高奖项为300元，总计额为932元

        在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：5,50,200,800,80,700
        最高奖项为800元，总计额为1835元

                在此次抽奖过程中,抽奖箱2中产生了最大奖项,该奖项金额为800元
        核心逻辑：获取线程抽奖的最大值（看成是线程运行的结果）


        以上打印效果只是数据模拟,实际代码运行的效果会有差异*/

        test7 test7 = new test7();
        FutureTask<Integer> ft1=new FutureTask<>(test7);
        FutureTask<Integer> ft2=new FutureTask<>(test7);

        Thread t1=new Thread(ft1,"抽奖箱1");
        Thread t2=new Thread(ft2,"抽奖箱2");

        t1.start();
        t2.start();

        int max2 = ft2.get();
        int max1 = ft1.get();
        if (max1>max2){
            System.out.println("抽奖箱1产生了最大奖项:"+max1);
        }
        else {
            System.out.println("抽奖箱2产生了最大奖项:"+max2);
        }
    }
}
