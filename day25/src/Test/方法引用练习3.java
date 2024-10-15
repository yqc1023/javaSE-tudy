package Test;

import java.util.ArrayList;
import java.util.Arrays;

public class 方法引用练习3 {
    public static void main(String[] args) {
        /*
         *   需求：
         *       创建集合添加学生对象
         *       学生对象属性：name，age
         *   要求：
         *       把姓名和年龄拼接成：张三-23的字符串，并放到数组当中
         *       使用方法引用完成
         * */

      ArrayList<Student> list2 = new ArrayList<>();
        list2.add(new Student("zhangsan",23));
        list2.add(new Student("lisi",24));
        list2.add(new Student("wangwu",25));

        String[] array = list2.stream().map(Student::getStr).toArray(String[]::new);
        System.out.println(Arrays.toString(array));

    }

}
