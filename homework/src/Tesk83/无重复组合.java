package Tesk83;

public class 无重复组合 {
    public static void main(String[] args) {
        int sum=0;
        for (int i = 4; i <8; i++) {
            for (int j = 4; j <8; j++) {
                for (int k = 4; k <8; k++) {
                  sum=i*100+j*10+k;
                  if(i!=j&&j!=k&&k!=i){
                      System.out.println(sum);
                  }
                }
            }
        }

    }
}
