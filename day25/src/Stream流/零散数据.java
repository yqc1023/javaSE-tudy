package Stream流;

import java.util.stream.Stream;

public class 零散数据 {
    public static void main(String[] args) {
        //一堆零散数据   public static<T> Stream<T> of(T... values)           Stream接口中的静态方法
        //1.创建数组
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        String[] arr2 = {"a","b","c"};

        Stream.of(1,2,3,4,5,6).forEach(s-> System.out.println(s));

        //注意：
        //Stream接口中静态方法of的细节
        //方法的形参是一个可变参数，可以传递一堆零散的数据，也可以传递数组
        //但是数组必须是引用数据类型的，如果传递基本数据类型，是会把整个数组当做一个元素，放到Stream当中。

        Stream.of(arr1).forEach(s-> System.out.println(s));//[I@41629346
        Stream.of(arr2).forEach(s-> System.out.println(s));
        Stream.of(1,2,3,4,5).forEach(s-> System.out.println(s));


    }
}
