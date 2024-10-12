package Test;

import cn.hutool.core.io.FileUtil;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class 随机点名器4 {
    public static void main(String[] args) throws IOException {

/*需求：
            一个文件里面存储了班级同学的姓名，每一个姓名占一行。
            要求通过程序实现随机点名器。

          运行结果要求：
            被点到的学生不会再被点到。
            但是如果班级中所有的学生都点完了， 需要重新开启第二轮点名。

          核心思想：
               点一个删一个，把删除的备份，全部点完时还原数据。

        */

        //1.定义变量，表示初始文件路径，文件中存储所有的学生信息
        String src = "E:\\java代码\\xiangmu\\src\\day29\\allnames.txt";
        //2.定义变量，表示备份文件，一开始文件为空
        String backups = "E:\\java代码\\xiangmu\\src\\day29\\c.txt";
        //3.读取初始文件中的数据，并把学生信息添加到集合当中
        ArrayList<String> list2=new ArrayList<>();

        ArrayList<String> list1=new ArrayList<>();
        FileUtil.readLines(src,"UTF-8",list1);
        FileUtil.readLines(backups,"UTF-8",list2);

        //判断，如果所有人均被选中
                                //则backup名单有10个人,src名单中没有数据
                                //此时要将backup中的数据重新写入初始名单src中,并把backup清空
        //      如果还有人没有被选中
                                //则继续选人并判断是否与backup名单重复
        if (!list1.isEmpty()) {
            //选出人并判断是否重复
            while (true) {
                Collections.shuffle(list1);
                String s = list1.get(0);
                System.out.println(s);
                if (!list2.contains(s)){
                    //定义方法将被选人s 续写 入backup
                    writeInC(s,backups,true);
                    list1.remove(s);
                    break;
                }
            }
            System.out.println("----------------------------------------------------");
        }
        else {
            list1.addAll(list2);
            list2.clear();
            FileUtil.writeLines(list2,backups,"UTF-8");
        }

        FileUtil.writeLines(list1,src,"UTF-8");
    }

    /*
    参数一: s  被选人名字

    参数二: backups 已选名单的文件路径

    参数三: continueToWrite 是否续写

    定义方法将被选人s 续写 入backup
    */
    public static void writeInC(String s,String backups,boolean continueToWrite) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter(backups,continueToWrite));
        bw.write(s);
        bw.newLine();
        bw.close();
    }
}
