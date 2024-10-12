package 获取class对象;

import java.io.*;

public class 获取class对象方式 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        /*
         * 获取class对象的三种方式：
         *   1. Class.forName("全类名");
         *   2. 类名.class
         *   3. 对象.getClass();
         *
         * */

        //第一种.Class.forName("全类名");
        //全类名:包名+类名
        //最常用

        Class<?> clazz = Class.forName("获取class对象.Student");

        //第二种.类名.class
        //一般当做参数传递
        Class clazz2 = Student.class;

        //第三种.对象.getClass()
        //当有了类对象时使用

        Student stu=new Student();
        Class clazz3 = stu.getClass();


    }
}
