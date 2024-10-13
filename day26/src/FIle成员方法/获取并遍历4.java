package FIle成员方法;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class 获取并遍历4 {
    public static void main(String[] args) {
    /*

        public File[] listFiles(FileFilter filter)      利用文件名过滤器获取当前该路径下所有内容
        public File[] listFiles(FilenameFilter filter)  利用文件名过滤器获取当前该路径下所有内容
      */

        //1.创建File对象
        File f = new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa");
        for (File file : f.listFiles( pathname-> {
                if (pathname.isFile() && pathname.getName().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        )) {
            System.out.println(file);
        }
        for (File file : f.listFiles(( dir,  name)-> {
                File scr = new File(dir, name);
                if (scr.isFile() && scr.getName().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        )) {
            System.out.println(file);
        }

    }
}