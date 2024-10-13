package FIleOutStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        //1.创建对象
                //参数是字符串表示的路经或者是File对象都是可以的
                //如果文件不存在会创建一个新的文件，但是要保证父级路经是存在的
                //如果文件已经存在会清空文件
        //写出 输出流 OutputStream(抽象类)
        //本地文件 File
        FileOutputStream fos=new FileOutputStream("day27\\a.txt");
        //2.写出数据
                //write方法的参数是整数，但是世界上写到本地文件中的是整数在ASCII码表上的字符
        fos.write(57);
        fos.write(55);
        //3.释放资源
                //每次使用完流后都要释放资源.
        fos.close();
    }
}
