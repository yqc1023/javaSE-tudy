package Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class 随机点名器1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bw=new BufferedReader(new FileReader("E:\\java代码\\xiangmu\\src\\day29\\a.txt"));
        ArrayList<String> list=new ArrayList<>();
        String s;
        while ((s=bw.readLine())!=null){
            list.add(s);
        }
        Collections.shuffle(list);
        Random r=new Random();
        System.out.println(list.get(r.nextInt(list.size())).split("-")[0]);
    }
}
