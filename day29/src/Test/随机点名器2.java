package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class 随机点名器2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("E:\\java代码\\xiangmu\\src\\day29\\a.txt"));
        ArrayList<String> boy=new ArrayList<>();
        ArrayList<String> girl=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        int boyCount=0;
        int girlCount=0;
        String s;
        while ((s=br.readLine())!=null){
            if (s.split("-")[1].equals("女")){
                girl.add(s);
                continue;
            }
            boy.add(s);
        }
        Collections.addAll(list,1,1,1,1,1,1,1,0,0,0);
        Collections.shuffle(list);
        System.out.println(list);
        Random r=new Random();
        for (int i = 0; i < 1000000; i++) {
            int Index = list.get(r.nextInt(list.size()));
            if (Index==1){
                Collections.shuffle(boy);
                boyCount++;
            }
            else if (Index==0){
                Collections.shuffle(girl);
                girlCount++;
            }
        }

        System.out.println(boyCount);
        System.out.println(girlCount);
    }
}
