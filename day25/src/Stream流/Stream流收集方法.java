package Stream流;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream流收集方法 {
    public static void main(String[] args) {

        /*
            collect(Collector collector)            收集流中的数据，放到集合中 (List Set Map)

            注意点：
                如果我们要收集到Map集合当中，键不能重复，否则会报错
       */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-男-15", "周芷若-女-14", "赵敏-女-13", "张强-男-20",
                "张三丰-男-100", "张翠山-男-40", "张良-男-35", "王二麻子-男-37", "谢广坤-男-41");
        //收集到list集合当中（不能去重复）
        List<String> newlist = list.stream().filter(s -> s.split("-")[1].equals("男")).collect(Collectors.toList());
        System.out.println(newlist);
        //收集到set集合当中(可以去重复)
        Set<String> newSet = list.stream().filter(s -> s.split("-")[1].equals("男")).collect(Collectors.toSet());
        System.out.println(newSet);
        //收集到Map当中
        //键：姓名，值：年龄
        Map<String, Integer> map = list.stream().filter(s -> s.split("-")[1].equals("男"))
                /*注意点：
                如果我们要收集到Map集合当中，键不能重复，否则会报错
                  toMap:参数一表示生成规则、
                        参数二表示值的生成规则
                  参数一：
                        Function泛型一：表示流中每一个数据的类型
                                 泛型二：表示Map集合中键的数据类型
                        方法apply的形参，一次表示流里面的每一个数据
                                  方法体：生成键的代码
                                  返回已经生成的键

                   参数二：
                        Function泛型一：表示流中每一个数据的类型
                                 泛型二：表示Map集合中键的数据类型
                        方法apply的形参，一次表示流里面的每一个数据
                                  方法体：生成值的代码
                                  返回已经生成的值
                  */
                .collect(Collectors.toMap(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split("-")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[2]);
                    }
                }));


        Map<String, String> map1 = list.stream().filter(s -> s.split("-")[1].equals("男"))
                .collect(Collectors.toMap(s -> s.split("-")[0], s -> s.split("-")[2]));
        System.out.println(map1);
    }
}
