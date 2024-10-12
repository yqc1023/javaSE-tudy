package 每日一记;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class 写入 {
    public 写入(String newTitle,String newContent,int i)  {
        try {
            File file = new File("E:\\java代码\\xiangmu\\day30\\src\\文件存放处\\"+i+".txt");
          file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(newTitle+"&"+newContent);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
