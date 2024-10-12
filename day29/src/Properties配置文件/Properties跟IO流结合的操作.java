package Properties配置文件;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Properties跟IO流结合的操作 {
    public static void main(String[] args) throws IOException {
        /*

              Properties跟IO流结合的操作

        */

        //1.创建集合
        Properties prop = new Properties();

        //2.添加数据
        prop.put("aaa", "bbb");
        prop.put("bbb", "ccc");
        prop.put("ddd", "eee");
        prop.put("fff", "iii");


        //3.把集合中的数据以键值对的形式写到文本中
        /*BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\java代码\\xiangmu\\src\\day29\\properties"));
        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            bw.write(key+"="+value);
            bw.newLine();
        }
        bw.close();*/

        FileOutputStream fos = new FileOutputStream("E:\\java代码\\xiangmu\\src\\day29\\properties");
        prop.store(fos, "test");
        fos.close();


    }
}
