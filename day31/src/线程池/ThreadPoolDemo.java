package 线程池;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
          /*
        public static ExecutorService newCachedThreadPool()             创建一个没有上限的线程池
        public static ExecutorService newFixedThreadPool (int nThreads) 创建有上限的线程池
    */


        //1.获取线程池对象
        ExecutorService pool1= Executors.newFixedThreadPool(3);

        pool1.submit(new ThreadPool());
        Thread.sleep(1000);
        pool1.submit(new ThreadPool());
        Thread.sleep(1000);
        pool1.submit(new ThreadPool());


        pool1.shutdown();
    }

}
