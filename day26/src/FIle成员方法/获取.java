package FIle成员方法;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class 获取 {
    public static void main(String[] args) {
        /*
        public long length()                返回文件的大小（字节数量）
        public String getAbsolutePath()     返回文件的绝对路径
        public String getPath()             返回定义文件时使用的路径
        public String getName()             返回文件的名称，带后缀
        public long lastModified()          返回文件的最后修改时间（时间毫秒值）
     */

        //1.length  返回文件的大小（字节数量）

        //细节1：这个方法只能获取 文件 的大小，单位是 字节
        //如果单位我们要是M，G，可以不断的除以1024
        //细节2：这个方法 无法获取文件夹 的大小
        //如果我们要获取一个文件夹的大小，需要把这个文件夹里面所有的文件大小都累加在一起。
        //文件
        File f1 = new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa\\a.txt");
        long length1 = f1.length();
        System.out.println(length1);//9
        //文件夹
        File f2=new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa\\bbb");
        long length2 = f2.length();
        System.out.println(length2);//0

        System.out.println("====================================");

        //2.getAbsolutePath 返回文件的绝对路径
        File f3=new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa\\a.txt");
        String path1 = f3.getAbsolutePath();
        System.out.println(path1);//E:\java网课\JavaSE下\day27-IO(异常&File&综合案例）\代码\myfile\aaa\a.txt

        File f4=new File("FIle成员方法\\a.txt");
        String path2 = f4.getAbsolutePath();
        System.out.println(path2);//E:\java代码\xiangmu\FIle成员方法\a.txt

        System.out.println("====================================");

        //3.getPath 返回定义文件时使用的路径
        File f5=new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa\\a.txt");
        String path3 = f5.getPath();
        System.out.println(path3);//E:\java网课\JavaSE下\day27-IO(异常&File&综合案例）\代码\myfile\aaa\a.txt

        File f6=new File("FIle成员方法\\a.txt");
        String path4 = f6.getPath();
        System.out.println(path4);//FIle成员方法\a.txt

        System.out.println("====================================");


        //4.getName 获取名字
        //细节1：
        //a.txt:
        //      a 文件名
        //      txt 后缀名、扩展名
        //细节2：
        //文件夹：返回的就是文件夹的名字
        File f7=new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa\\a.txt");
        String name1 = f7.getName();
        System.out.println(name1);//a.txt

        File f8=new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa\\bbb");
        String name2 = f8.getName();
        System.out.println(name2);//bbb

        System.out.println("====================================");

        //5.lastModified  返回文件的最后修改时间（时间毫秒值）
        File f9 = new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa\\a.txt");
        long time = f9.lastModified();
        System.out.println(time);//1716985596448

        //如何把时间的毫秒值变成字符串表示的时间呢？
        //课堂练习：
        //yyyy年MM月dd日 HH：mm：ss
        Date date=new Date(time);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH：mm：ss");
        String format = sdf.format(date);
        System.out.println(format);


    }
}
