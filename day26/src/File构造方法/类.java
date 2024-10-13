package File构造方法;

import java.io.File;

public class 类 {
    public static void main(String[] args) {
        /*
        public File(String pathname)                根据文件路径创建文件对象
        public File(String parent, String child)    根据父路径名字符串和子路径名字符串创建文件对象
        public File(File  parent, String child)     根据父路径对应文件对象和子路径名字符串创建文件对象

        C:\Users\alienware\Desktop
        \:转移字符
    */
        //1.根据字符串表示的路径，变成File对象
        String str="C:\\Users\\alienware\\Desktop\\a.txt";
        File f1=new File(str);
        System.out.println(f1);//C:\Users\alienware\Desktop\a.txt


        //2.父级路经://C:\Users\alienware\Desktop
        //子级路经:a.txt
        String parent="C:\\Users\\alienware\\Desktop";
        String child="a.txt";
        File f2=new File(parent,child);
        System.out.println(f2);//C:\Users\alienware\Desktop\a.txt


        File f3=new File(parent+"\\"+child);
        System.out.println(f3);//C:\Users\alienware\Desktop\a.txt

        File parent2=new File("C:\\Users\\alienware\\Desktop");
        String child2="a.txt";
        File f4=new File(parent2,child2);
        System.out.println(f4);//C:\Users\alienware\Desktop\a.txt
    }
}
