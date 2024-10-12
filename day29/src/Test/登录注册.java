package Test;

import java.io.*;
import java.util.Scanner;

public class 登录注册 {
    public static void main(String[] args) throws IOException {
        /*
        需求：写一个登陆小案例。

        步骤：
            将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
            保存格式为:username=zhangsan&password=123
            让用户键盘录入用户名和密码
                    比较用户录入的和正确的用户名密码是否一致
            如果一致则打印登陆成功
                    如果不一致则打印登陆失败
        */

        //1.读取正确的用户名和密码
        BufferedReader br = new BufferedReader(new FileReader("E:\\java代码\\xiangmu\\src\\day29\\userir"));
        String line = br.readLine();
        br.close();
        BufferedReader brNumber = new BufferedReader(new FileReader("E:\\java代码\\xiangmu\\src\\day29\\count"));
        String lineNumber = brNumber.readLine();
        System.out.println(lineNumber);
        brNumber.close();

        String userName = line.split("&")[0].split("=")[1];
        String userPassword = line.split("&")[1].split("=")[1];

        //用户输入名字和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String inputName = sc.nextLine();
        System.out.println("请输入密码");
        String inputPassword = sc.nextLine();


        int i = Integer.parseInt(lineNumber);
        System.out.println(i);
        //判断是否正确
        if (i < 3) {
            if (inputName.equals(userName) && inputPassword.equals(userPassword)) {
                System.out.println("登陆成功");
                xiugai("0",lineNumber,"E:\\java代码\\xiangmu\\src\\day29\\count");
            } else {
                i++;
                xiugai(i+"",lineNumber,"E:\\java代码\\xiangmu\\src\\day29\\count");
                System.out.println("密码或用户名不一致");
                System.out.println("登陆失败");
            }
        }
        else {
            System.out.println("账户已被锁定");
            xiugai("0",lineNumber,"E:\\java代码\\xiangmu\\src\\day29\\count");
        }


    }
    public static void xiugai(String line,String Number,String Path) throws IOException {
        Number = line;
        BufferedWriter bw = new BufferedWriter(new FileWriter(Path));
        bw.write(Number);
        bw.close();
    }
}
