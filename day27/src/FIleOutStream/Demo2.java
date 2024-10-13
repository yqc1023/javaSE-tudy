package FIleOutStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
         /*
           void write(int b)                       一次写一个字节数据
           void write(byte[] b)                    一次写一个字节数组数据
           void write(byte[] b, int off, int len)  一次写一个字节数组的部分数据
           参数一：
                数组
           参数二：
                起始索引  0
           参数三：
                个数      3
        */
        //1.创建对象
        FileOutputStream fos = new FileOutputStream("day27\\a.txt");
        //2.写出数据
//        fos.write(97);


       byte[] bytes = {97, 98, 99, 100,101};
       /* fos.write(bytes);*/
        fos.write(bytes,1,2);
        //从1索引开始，写2个

        //3.释放资源
        fos.close();
    }
}
