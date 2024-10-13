package FileInputStream;

import java.io.*;

public class 文件拷贝 {
    public static void main(String[] args) throws IOException {
        /*
         *   练习：
         *       文件拷贝
         *       把"E:\java网课\JavaSE下\day28-IO（字节流&字符流）\代码\myio\src\com\itheima\b.txt"拷贝到当前模块下。
         *
         *   注意：
         *       选择一个比较小的文件，不要太大。大文件拷贝我们下一个视频会说。
         *
         *
         *
         *   课堂练习：
         *       要求统计一下拷贝时间，单位毫秒
         * */
        long star = System.currentTimeMillis();
        //1.创建对象
        FileOutputStream fos=new FileOutputStream("E:\\java代码\\xiangmu\\day27\\b.txt",true);
        FileInputStream fis = new FileInputStream("E:\\java代码\\xiangmu\\day27\\a.txt");

        //2.拷贝
        //核心思想：边读边写
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        long end = System.currentTimeMillis();
        System.out.println((end-star));
        //3.释放资源
        //规则：先开的最后关闭
        fis.close();
        fos.close();

    }
}
