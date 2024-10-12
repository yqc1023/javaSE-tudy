package 获取构造方法的对象;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
/*
        Class类中用于获取构造方法的方法
            Constructor<?>[] getConstructors()                                返回所有公共构造方法对象的数组
            Constructor<?>[] getDeclaredConstructors()                        返回所有构造方法对象的数组
            Constructor<T> getConstructor(Class<?>... parameterTypes)         返回单个公共构造方法对象
            Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) 返回单个构造方法对象


        Constructor类中用于创建对象的方法
            T newInstance(Object... initargs)                                 根据指定的构造方法创建对象
            setAccessible(boolean flag)                                       设置为true,表示取消访问检查
    */

        //1.获取class字节码文件对象
        Class clazz = Class.forName("获取构造方法的对象.Student");

        //2.获取构造方法对象
        //获取所有公共的(public)
        Constructor[] cons = clazz.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }

        System.out.println("----------------------------------");

        //获取所有,包括私有
        Constructor[] cons2 = clazz.getDeclaredConstructors();
        for (Constructor con : cons2) {
            System.out.println(con);
        }

        System.out.println("----------------------------------");


        //返回单个构造方法对象
        Constructor cons3 = clazz.getDeclaredConstructor();
        System.out.println(cons3);


        System.out.println("----------------------------------");

        Constructor cons4 = clazz.getDeclaredConstructor(String.class,int.class);
        System.out.println(cons4);

        System.out.println("----------------------------------");

        //获取该构造方法的权限修饰符(显示出的是常量字段值)
        int modifiers = cons4.getModifiers();
        System.out.println(modifiers);//1 public

        System.out.println("----------------------------------");


        //获得构造方法的所有参数
        Parameter[] parameters = cons4.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

        System.out.println("----------------------------------");

        //通过构造方法的对象来创建该类的对象
        //临时取消权限校验(暴力反射  强制使用私有化的构造方法)
        cons4.setAccessible(true);
        //cons4是有参的构造,创建对象时就得放入参数



        Method yes = clazz.getMethod("yes");
        yes.setAccessible(true);
        yes.invoke(new Student("张三",22));
    }
}
