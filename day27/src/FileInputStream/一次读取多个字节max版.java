package FileInputStream;

import java.io.*;

public class 一次读取多个字节max版 {
    public static void main(String[] args) throws IOException {
        /*
         *   练习：
         *       文件拷贝
         *       把D:\itheima\movie.mp4 (16.8 MB) 拷贝到当前模块下。
         *
         * */
        long star = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("day27\\a.txt");
        FileOutputStream fos = new FileOutputStream("day27\\c.txt", true);
        byte[] bytes = new byte[5];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println(end - star);
    }
}
