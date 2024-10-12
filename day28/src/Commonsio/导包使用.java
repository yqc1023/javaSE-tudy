package Commonsio;



import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class 导包使用 {
    public static void main(String[] args) throws IOException {
        /*
          FileUtils类
                static void copyFile(File srcFile, File destFile)                   复制文件
                static void copyDirectory(File srcDir, File destDir)                复制文件夹
                static void copyDirectoryToDirectory(File srcDir, File destDir)     复制文件夹
                static void deleteDirectory(File directory)                         删除文件夹
                static void cleanDirectory(File directory)                          清空文件夹
                static String readFileToString(File file, Charset encoding)         读取文件中的数据变成成字符串
                static void write(File file, CharSequence data, String encoding)    写出数据

            IOUtils类
                public static int copy(InputStream input, OutputStream output)      复制文件
                public static int copyLarge(Reader input, Writer output)            复制大文件
                public static String readLines(Reader input)                        读取数据
                public static void write(String data, OutputStream output)          写出数据
         */


        /*File src = new File("day28\\a.txt");
        File dest = new File("day28\\b.txt");
        FileUtils.copyFile(src,dest);*/


        /*File src = new File("E:\\java网课\\JavaSE下\\day29-IO（其他流）\\代码\\myio\\aaa");
        File dest = new File("E:\\java网课\\JavaSE下\\day29-IO（其他流）\\代码\\myio\\bbb");
        FileUtils.copyDirectory(src,dest);*/

        File src = new File("E:\\java网课\\JavaSE下\\day29-IO（其他流）\\代码\\myio\\aaa");
        File dest = new File("E:\\java网课\\JavaSE下\\day29-IO（其他流）\\代码\\myio\\bbb");
        FileUtils.deleteDirectory(src);//整个文件夹全部删除
        FileUtils.cleanDirectory(dest);//清空里面的东西,文件夹本身还在

    }
}
