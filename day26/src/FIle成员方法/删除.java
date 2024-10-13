package FIle成员方法;

import java.io.File;

public class 删除 {
    public static void main(String[] args) {
         /*
        public boolean delete()             删除文件、空文件夹
        细节：
            如果删除的是文件，则直接删除，不走回收站。
            如果删除的是空文件夹，则直接删除，不走回收站
            如果删除的是有内容的文件夹(多级也算有内容)，则删除失败
      */

        //1.创建File对象
        File f1 = new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa\\aaa");
        //2.删除
        boolean delete = f1.delete();
        System.out.println(delete);//false
    }
}
