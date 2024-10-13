package FIle成员方法;

import java.io.File;
import java.io.FilenameFilter;

public class 获取并遍历3 {
    public static void main(String[] args) {
    /*
        （掌握）public File[] listFiles()                获取当前该路径下所有内容
        public File[] listFiles(FileFilter filter)      利用文件名过滤器获取当前该路径下所有内容
        public File[] listFiles(FilenameFilter filter)  利用文件名过滤器获取当前该路径下所有内容
      */


        //1.创建File对象
        File f = new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa");
        File[] files = f.listFiles();
        for (File file : files) {
            //file依次表示aaa文件夹里面每一个文件或者文件夹的路径
            if (file.isFile()&&file.getName().endsWith(".txt")){
                System.out.println(file);
            }
        }

    }
}