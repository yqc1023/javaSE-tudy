package 获取成员变量的对象;

import java.lang.reflect.Field;

public class MyReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
    /*
       Class类中用于获取成员变量的方法
            Field[] getFields()：                返回所有公共成员变量对象的数组
            Field[] getDeclaredFields()：        返回所有成员变量对象的数组
            Field getField(String name)：        返回单个公共成员变量对象
            Field getDeclaredField(String name)：返回单个成员变量对象

       Field类中用于创建对象的方法
            void set(Object obj, Object value)：赋值
            Object get(Object obj)              获取值

    */


        //1.获取class字节码文件的对象
        Class clazz = Class.forName("获取成员变量的对象.Student");

        //2.获取存储所有公共成员变量的对象数组
        Field[] fields = clazz.getFields();

        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("=================================");


        //3.获取存储所有成员变量的对象数组
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            System.out.println(field);
        }

        System.out.println("=================================");

        //4.返回单个公共成员变量对象(参数写变量的名字的字符串形式)
        Field gender = clazz.getField("gender");
        System.out.println(gender);

        //5.返回单个成员变量对象
        Field age = clazz.getDeclaredField("age");
        System.out.println(age);

        //6.用成员变量的对象获取成员变量的权限修饰符
        int modifiers = age.getModifiers();
        System.out.println(modifiers);

        //7.用成员变量的对象获取成员变量的变量名
        String name = age.getName();
        System.out.println(name);

        //8.用成员变量的对象获取成员变量的数据类型
        Class<?> type = age.getType();
        System.out.println(type);

        //9.用成员变量记录的值
        Student student = new Student("张三",23,"男");
        //临时取消权限校验(暴力反射  强制使用私有化的成员变量)
        age.setAccessible(true);
        int vaule = (int) age.get(student);

        System.out.println(vaule);

        System.out.println("===============================");

        //10.修改对象记录的值
        //临时取消权限校验(暴力反射  强制使用私有化的成员变量)
        age.setAccessible(true);

        age.set(student,10);
        System.out.println(age.get(student));
    }
}