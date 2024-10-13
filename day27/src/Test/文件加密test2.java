package Test;

import java.io.*;

public class 文件加密test2 {
    public static void main(String[] args) throws IOException {
        File yuan=new File("E:\\java网课\\JavaSE下\\day28-IO（字节流&字符流）\\代码\\myio\\src\\com\\itheima\\yuan.txt");
        File mi=new File("E:\\java网课\\JavaSE下\\day28-IO（字节流&字符流）\\代码\\myio\\src\\com\\itheima\\mi.txt");
        File jie=new File("E:\\java网课\\JavaSE下\\day28-IO（字节流&字符流）\\代码\\myio\\src\\com\\itheima\\jiemi.txt");
        FileReader fr = new FileReader(yuan);
        FileWriter fw = new FileWriter(mi);
        int len;
        while ((len = fr.read()) != -1) {
            fw.write((char) (len^2));
        }
        //yuan.delete();
        fw.close();
        fr.close();

        FileReader mifr=new FileReader(mi);
        FileWriter jiefw=new FileWriter(jie);
        while ((len = mifr.read()) != -1) {
            jiefw.write((char) (len^2));
        }
        mifr.close();
        jiefw.close();
    }

}
