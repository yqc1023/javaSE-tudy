package Test;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        /*
            需求：
                键盘录入自己心仪的女朋友姓名和年龄。
                姓名的长度在 3 - 10之间，
                年龄的范围为 18 - 40岁,
                超出这个范围是异常数据不能赋值，需要重新录入,一直录到正确为止。
            提示：
                需要考虑用户在键盘录入时的所有情况。
                比如：录入年龄时超出范围，录入年龄时录入了abc等情况
        */
        GirlFriend2 girlFriend = new GirlFriend2();
        Scanner sc=new Scanner(System.in);
        while (true) {
            try {
                System.out.println("请输入女朋友的姓名：");
                String name = sc.nextLine();
                girlFriend.setName(name);
                System.out.println("请输入女朋友的年龄：");
                String ageStr = sc.nextLine();
                int age = Integer.parseInt(ageStr);
                girlFriend.setAge(age);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("年龄的格式有误，请重新输入");
            }
            catch (NameFormatException e) {
                e.printStackTrace();
            } catch (AgeOutOfBoundsException e) {
                e.printStackTrace();
            }

        }
        System.out.println(girlFriend);
    }
}
