package Test;

public class GirlFriend1 {
    private String name;
    private int age;


    public GirlFriend1() {
    }

    public GirlFriend1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        if (name.length()<3||name.length()>10){
            throw new RuntimeException();
        }
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        if (age>40||age<18){
            throw new RuntimeException();
        }
        else {
            this.age = age;
        }
    }

    public String toString() {
        return "GirlFriend1{name = " + name + ", age = " + age + "}";
    }
}
