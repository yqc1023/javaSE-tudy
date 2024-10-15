package Stream流;

import java.util.Arrays;

public class 数组 {
    public static void main(String[] args) {
        // 数组          public static <T> Stream<T> stream(T[] array)        Arrays工具类中的静态方法

        //1.创建数组
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};

        String[] arr2 = {"a","b","c"};

        //2.获取stream流
        Arrays.stream(arr1).forEach(s-> System.out.println(s));

        System.out.println("===========================================");

        Arrays.stream(arr2).forEach(s-> System.out.println(s));




    }
}
