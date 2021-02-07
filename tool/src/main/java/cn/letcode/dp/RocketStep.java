package cn.letcode.dp;

public class RocketStep {
    public int dp(int i,int j){
        if(i<=0||j<=0){
            return 0;
        }
        if(i==1&&j==1){
            return 1;
        }else{
            if(i==1 && j==2){
                return 1;
            }else if(i==2 && j==1){
                return 1;
            }
        }
        return dp(i-1,j)+dp(i,j-1);
    }

    public static void main(String[] args) {
        int dp = new RocketStep().dp(7, 3);
        System.out.println(dp);
        dp = new RocketStep().dp(8, 4);
        System.out.println(dp);
    }
}
