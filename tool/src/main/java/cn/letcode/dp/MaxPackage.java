package cn.letcode.dp;

public class MaxPackage {

    int[] weight = new int[]{1,3,5,3,2,2,4,5};
    int[] value = new int[]{10,30,40,33,20,17,35,36};

    public int f(int n) {

        int[][] dp = new int[n+1][weight.length+1];
        //dp[0][0]=0;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (j-1>0 && i - weight[j-1] >= 0 ) {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i - weight[j-1]][j-1] + value[j-1]);
                }
            }
        }
        return dp[n][weight.length - 1];
    }

    public static void main(String[] args) {
        MaxPackage maxPackage = new MaxPackage();
        System.out.println(maxPackage.f(11));
    }

}
