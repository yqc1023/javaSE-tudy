package Properties配置文件;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Properties作为map集合的操作 {
    public static void main(String[] args) {
         /*

              Properties作为Map集合的操作

        */

        //1.创建集合的对象
        Properties prop = new Properties();
        //2.添加数据
        //虽然可以添加任意数据类型,但是一般只添加字符串类型
        //map集合特性:键是唯一的,值可重复
        prop.put("aaa", "111");
        prop.put("bbb", "222");
        prop.put("ccc", "333");
        prop.put("ddd", "444");

        //3.打印集合
        /*Set<Object> keys = prop.keySet();
        for (Object key : keys) {
            Object value = prop.get(key);
            System.out.println(key+"="+value);
        }*/

        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }
}
