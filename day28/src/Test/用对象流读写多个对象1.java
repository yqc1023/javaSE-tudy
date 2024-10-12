package Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class 用对象流读写多个对象1 {
    public static void main(String[] args) throws IOException {
        Student s1=new Student("zhangsan",21,"南京");
        Student s2=new Student("lisi",22,"重庆");
        Student s3=new Student("wangwu",23,"汕头");
        Student s4=new Student("zhaoliu",24,"北京");
        ArrayList<Student> list=new ArrayList<>();
        Collections.addAll(list,s1,s2,s3,s4);
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("E:\\java代码\\xiangmu\\day28\\src\\Test\\a.txt"));

        oos.writeObject(list);


        oos.close();



    }
}
