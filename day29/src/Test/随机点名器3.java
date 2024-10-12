package Test;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class 随机点名器3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bw = new BufferedReader(new FileReader("E:\\java代码\\xiangmu\\src\\day29\\a.txt"));
        Random r = new Random();
        ArrayList<String> list = new ArrayList<>();
        String s;
        while ((s = bw.readLine()) != null) {
            list.add(s);
        }

        FileReader fr = new FileReader("E:\\java代码\\xiangmu\\src\\day29\\b.txt");
        int number = fr.read();
        fr.close();
        int i = number - 48;
        System.out.println(i);
        if (i==3) {
            System.out.println("张三");
            i++;
        }
        else {
            Collections.shuffle(list);
            System.out.println(list.get(r.nextInt(list.size())).split("-")[0]);
            i++;
        }
        String s1 = i + "";
        FileWriter fw=new FileWriter("E:\\java代码\\xiangmu\\src\\day29\\b.txt");
        fw.write(s1);
        fw.close();
        bw.close();
    }
}

