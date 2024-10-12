package Test;

import cn.hutool.core.io.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class 带权重的随机 {
    public static void main(String[] args) throws IOException {
        //1.把文件中所有的学生信息读取到内存中
        ArrayList<Student> list =new ArrayList<>();
        BufferedReader bw=new BufferedReader(new FileReader("E:\\java代码\\xiangmu\\src\\day29\\allnames.txt"));
        String  line;
        while ((line=bw.readLine())!=null) {
            String[] arr = line.split("-");
            Student stu = new Student(arr[0], arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]));
            list.add(stu);
        }
        bw.close();

       //2.计算权重的总和
        double weight=0;
        for (Student stu : list) {
            weight+=stu.getWeight();
        }
        System.out.println(weight);

        //3.计算出每个人的实际占比
        double[] arr=new double[10];
        for (int i = 0; i < list.size(); i++) {
            arr[i]=list.get(i).getWeight()/weight;
        }

        //4.计算每一个人的权重占比范围
        for (int i = 1; i < arr.length; i++) {
            arr[i]=arr[i]+arr[i-1];
        }

        //5.随机抽取
        //获取一个0.0~1.0的随机数
        double number = Math.random();
        //判断number在arr中的位置
        //二分查找发
        //返回 -插入点-1
        int result = -(Arrays.binarySearch(arr, number)+1);
        Student student = list.get(result);
        System.out.println(student);

        //6.修改当前学生的权重
        student.setWeight(student.getWeight()/2);
        System.out.println(list);
        //7.把集合中的数据写到文件中
        BufferedWriter bw2=new BufferedWriter(new FileWriter("E:\\java代码\\xiangmu\\src\\day29\\allnames.txt"));
        for (Student stu : list) {
           bw2.write(stu.toString());
           bw2.newLine();
        }
        bw2.close();

    }
}
