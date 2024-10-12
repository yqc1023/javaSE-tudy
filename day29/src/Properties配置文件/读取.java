package Properties配置文件;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class 读取 {
    public static void main(String[] args) throws IOException {
        //1.创建集合
        Properties prop = new Properties();

       //2.读取本地文件Properties文件里面的数据
        FileReader fr=new FileReader("E:\\java代码\\xiangmu\\src\\day29\\properties");
        prop.load(fr);
        fr.close();

        //3.打印集合
        System.out.println(prop);



    }
}
