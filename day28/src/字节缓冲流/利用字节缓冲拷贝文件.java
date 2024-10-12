package 字节缓冲流;

import java.io.*;

public class 利用字节缓冲拷贝文件 {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\java代码\\xiangmu\\day28\\b.txt"));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\java代码\\xiangmu\\day28\\a.txt"));
        int len;
        byte[] bytes=new byte[2];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
    }

}
