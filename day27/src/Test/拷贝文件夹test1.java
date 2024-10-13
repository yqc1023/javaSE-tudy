package Test;

import java.io.*;

public class 拷贝文件夹test1 {
    public static void main(String[] args) throws IOException {
        File dest = new File("E:\\java网课\\JavaSE下\\day28-IO（字节流&字符流）\\代码\\myio\\src\\com\\itheima\\src的copy");
        File src = new File("E:\\java网课\\JavaSE下\\day28-IO（字节流&字符流）\\代码\\myio\\src\\com\\itheima\\src");
        getcopy(src, dest);
    }
    public static void getcopy(File src, File dest) throws IOException {
        dest.mkdirs();
        //递归
        //1.进入数据源
        File[] files = src.listFiles();
        //2.遍历数组
        for (File file : files) {
            if(file.isFile()){
                //3.判断文件，拷贝
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest,file.getName()));
                byte[] bytes = new byte[1024];
                int len;
                while((len = fis.read(bytes)) != -1){
                    fos.write(bytes,0,len);
                }
                fos.close();
                fis.close();
            }else {
                //4.判断文件夹，递归
                getcopy(file, new File(dest,file.getName()));
            }
        }
    }

}
