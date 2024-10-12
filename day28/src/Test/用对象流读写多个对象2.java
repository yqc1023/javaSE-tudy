package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class 用对象流读写多个对象2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:\\java代码\\xiangmu\\day28\\src\\Test\\a.txt"));

        ArrayList<Student> list = (ArrayList<Student>) ois.readObject();
        for (Student student : list) {
            System.out.println(student);
        }
        ois.close();



    }
}
