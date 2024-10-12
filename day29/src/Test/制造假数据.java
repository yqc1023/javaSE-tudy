package Test;

import cn.hutool.core.io.FileUtil;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class 制造假数据 {
    public static void main(String[] args) throws IOException {
        /*
        制造假数据：
        获取姓氏：https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0
        获取男生名字：http://www.haoming8.cn/baobao/10881.html
        获取女生名字：http://www.haoming8.cn/baobao/7641.html
        */

        //1.定义变量记录网址
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        //2.爬取数据,把网址上所有的数据拼接成一个字符串
        String familyNameStr = webCrawler(familyNameNet);
        String boyNameStr = webCrawler(boyNameNet);
        String girlNameStr = webCrawler(girlNameNet);

        //3.通过正则表达式,把其中符合要求的数据获取出来
        ArrayList<String> familyNameTempList = getData(familyNameStr, "([\\u4E00-\\u9FA5]{4})，([\\u4E00-\\u9FA5]{4})。", 1);
        ArrayList<String> boyNameTempList = getData(boyNameStr, "([\\u4E00-\\u9FA5]{2})(、|。)", 1);
        ArrayList<String> girlNameTempList = getData(girlNameStr, "(.. ){4}..", 0);
        //4.处理数据
        //familyNameTempList（姓氏）
        //处理方案：把每一个姓氏拆开并添加到一个新的集合当中
        ArrayList<String> familyNameList = new ArrayList<>();
        for (String str : familyNameTempList) {

            //str 赵钱孙李  周吴郑王   冯陈褚卫   蒋沈韩杨
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                familyNameList.add(c + "");

            }
        }


        //boyNameTempList（男生的名字）
        //处理方案：去除其中的重复元素
        ArrayList<String> boyNameList = (ArrayList<String>) boyNameTempList.stream().distinct().collect(Collectors.toList());

        //girlNameTempList（女生的名字）
        //处理方案：把里面的每一个元素用空格进行切割，得到每一个女生的名字

        ArrayList<String> girlNameList = new ArrayList<>();
        for (String s : girlNameTempList) {
            String[] arr = s.split(" ");
            for (int i = 0; i < arr.length; i++) {
                girlNameList.add(arr[i]);
            }
        }


        //5.生成数据
        //姓名（唯一）-性别-年龄
        ArrayList<String> list = getInfos(familyNameList, boyNameList, girlNameList, 70, 50);
        System.out.println(list);

        //6.写出数据

        BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\java代码\\xiangmu\\src\\day29\\a.txt"));
        for (String s : list) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }

    /*
     * 作用：
     *   从网络中爬取数据，把数据拼接成字符串返回
     * 形参：
     *   网址
     * 返回值：
     *   爬取到的所有数据
     * */
    public static String webCrawler(String net) throws IOException {
        //1.定义StringBuilder拼接爬取到的数据
        StringBuilder sb = new StringBuilder();
        //2.创建一个URl对象
        URL url = new URL(net);
        //3.链接网址
        //3.链接上这个网址
        //细节：保证网络是畅通的，而且这个网址是可以链接上的。
        URLConnection conn = url.openConnection();
        //4.读取数据
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        //5.释放资源
        isr.close();
        return sb.toString();
    }

    /*
     * 作用：根据正则表达式获取字符串中的数据
     * 参数一：
     *       完整的字符串
     * 参数二：
     *       正则表达式
     * 参数三：
     *      获取数据
     *       0：获取符合正则表达式所有的内容
     *       1：获取正则表达式中第一组数据
     *       2：获取正则表达式中第二组数据
     *       ...以此类推
     *
     * 返回值：
     *       真正想要的数据
     *
     * */
    public static ArrayList<String> getData(String str, String regex, int Index) {
        //1.创建集合存放数据
        ArrayList<String> list = new ArrayList<>();
        //2.按照正则表达式的规则获取数据
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while (matcher.find()) {
            String s = matcher.group(Index);
            list.add(s);
        }
        return list;
    }

    /*
     * 作用：
     *      获取男生和女生的信息：张三-男-23
     *
     * 形参：
     *      参数一：装着姓氏的集合
     *      参数二：装着男生名字的集合
     *      参数三：装着女生名字的集合
     *      参数四：男生的个数
     *      参数五：女生的个数
     * */
    public static ArrayList<String> getInfos(ArrayList<String> familyNameList, ArrayList<String> boyNameList, ArrayList<String> girlNameList, int boyCount, int girlCount) {
        //1.生成不重复的名字
        HashSet<String> boyhs = new HashSet<>();
        while (true) {
            if (boyhs.size()==boyCount){
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
            String boyName = familyNameList.get(0) + boyNameList.get(0);

            if (!boyhs.contains(boyName)) {
                boyhs.add(boyName);
            }
        }
        HashSet<String> girlhs = new HashSet<>();
        while (true) {
            if (girlhs.size()==girlCount){
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);
            String girlName = familyNameList.get(0) + girlNameList.get(0);
            if (!girlhs.contains(girlName)) {
                girlhs.add(girlName);
            }
        }
        Random r=new Random();
        ArrayList<String> list=new ArrayList<>();
        for (String boyName : boyhs) {
            list.add(boyName+"-男-"+(r.nextInt(10)+18));
        }
        for (String girlName : girlhs) {
            list.add(girlName+"-女-"+(r.nextInt(10)+18));
        }
        return list;

    }
}
