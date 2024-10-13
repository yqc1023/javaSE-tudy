package FIle成员方法;

import java.io.File;

public class 获取并遍历1 {
    public static void main(String[] args) {
        //public File[] listFiles()       获取当前该路径下所有内容



        //1.创建File对象
        File f = new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa");
        //2.listFiles方法
        //作用：获取aaa文件夹里面的所有内容，把所有的内容放到数组中返回
        File[] files = f.listFiles();
        for (File file : files) {
            //file依次表示aaa文件夹里面的每一个文件或者文件夹
            System.out.println(file);
        }
    }
}
