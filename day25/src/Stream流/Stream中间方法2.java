package Stream流;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Stream;

public class Stream中间方法2 {
    public static void main(String[] args) {
        /*
            distinct            元素去重，依赖(hashCode和equals方法)
            concat              合并a和b两个流为一个流   Stream接口中的静态方法

            注意1：中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
            注意2：修改Stream流中的数据，不会影响原来集合或者数组中的数据
        */

        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌","张无忌","张无忌", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "周芷若", "赵敏");

       //concat              合并a和b两个流为一个流   Stream接口中的静态方法
        list1.stream().distinct().forEach(s -> System.out.print(s+"  "));
        System.out.println();
        Stream.concat(list1.stream(),list2.stream()).forEach(s -> System.out.print(s+"  "));

         /*
            map                 转换流中的数据类型

            注意1：中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
            注意2：修改Stream流中的数据，不会影响原来集合或者数组中的数据
        */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-15", "周芷若-14", "赵敏-13", "张强-20", "张三丰-100", "张翠山-40", "张良-35", "王二麻子-37", "谢广坤-41");

        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                String[] arr = s.split("-");
                String arrString = arr[1];
                int age = Integer.parseInt(arrString);
                return age;
            }
        }).forEach(s-> System.out.println(s));


        list.stream().map(s -> Integer.parseInt(s.split("-")[1])).forEach(s -> System.out.print(s+"  "));

    }
}
