package FileTest;

import java.io.File;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class test6 {
    static HashMap<String,Integer> hm=new HashMap<>();
    public static void main(String[] args) {
/*
            需求：统计一个文件夹中每种文件的个数并打印。（考虑子文件夹）
            打印格式如下：
            txt:3个
            doc:4个
            jpg:6个


        */
        File f=new File("E:\\java网课\\JavaSE下\\day27-IO(异常&File&综合案例）\\代码\\myfile\\aaa");
        getCount(f);
        hm.forEach(( s,  integer)-> System.out.println("."+s+": "+integer+"个"));
    }
    public static void getCount(File f){

        File[] files = f.listFiles();
        if (files!=null){
            for (File file : files) {
                if (file.isFile()){
                    String name = file.getName();
                    String[] arr = name.split("\\.");
                        if (arr.length>=2){
                            String endName = arr[arr.length - 1];
                            if (!hm.containsKey(endName)){
                                hm.put(endName,1);
                            }
                            else {
                                Integer i = hm.get(endName);
                                i++;
                                hm.put(endName,i);
                            }
                        }
                }
                else {
                    getCount(file);
                }
            }
        }
    }
}
