package cn.letcode.dp;

public class MaxMoney {

    int[] colum = new int[]{1,2,3,4, 5, 6, 7, 8, 9};
    int[] money = new int[]{1,3,7,7,10,12,14,16,20};

    public int theMax(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return money[0];
        }
        int resVal = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            resVal = Math.max(resVal,money[i] +theMax(n-i));
        }
        return resVal;
    }

    public static void main(String[] args) {
        MaxMoney maxMoney = new MaxMoney();
        int i = maxMoney.theMax(9);
        System.out.println(i);
    }
}
