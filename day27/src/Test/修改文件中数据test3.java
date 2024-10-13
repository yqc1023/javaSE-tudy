package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 修改文件中数据test3 {
    public static void main(String[] args) throws IOException {
          /*
            文本文件中有以下的数据：
                2-1-9-4-7-8
            将文件中的数据进行排序，变成以下的数据：
                1-2-4-7-8-9

                 细节1：
                文件中的数据不要换行


            细节2:
                bom头
        */

        //1.读取数据
        FileReader fr = new FileReader("E:\\java代码\\xiangmu\\day27\\d.txt");
        StringBuilder sb = new StringBuilder();
        int len;
        while ((len = fr.read()) != -1) {
            sb.append((char) len);
        }
        fr.close();
        //2.排序
        Integer[] arr = Arrays.stream(sb.toString()
                        .split("-"))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);
        //3.写出
        FileWriter fw = new FileWriter("\\day27\\d.txt");
        String s = Arrays.toString(arr).replace(", ","-");
        String result = s.substring(1, s.length() - 1);
        fw.write(result);
        fw.close();
    }
}
