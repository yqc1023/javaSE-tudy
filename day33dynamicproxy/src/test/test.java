package test;

public class test {
    public static void main(String[] args) {
        /*

需求：
            *   外面的人想要大明星唱一首歌
    *   1. 获取代理的对象
    *      代理对象 = ProxyUtil.createProxy(大明星的对象);
    *   2. 再调用代理的唱歌方法
    *      代理对象.唱歌的方法("只因你太美");
    */
        BigStar bigStar = new BigStar("cxk");
        Star proxy = ProxyUtil.createProxy(bigStar);

        //自动调用PRoxyUtil中匿名内部类中的invoke方法
        //第一个参数就是proxy(代理的对象)
        //第二个参数是sing()(代理中要运行的方法)
        //第三个参数是"只因你太美"(参数二中要带入的实参)
        String result = proxy.sing("只因你太美");

        System.out.println(result);

    }
}
