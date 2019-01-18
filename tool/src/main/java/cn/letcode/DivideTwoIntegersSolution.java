package cn.letcode;

public class DivideTwoIntegersSolution {
    public int divide(int dividend, int divisor) {
        int flag=1;
        if(dividend<0){
            flag=-flag;
            dividend=-dividend;
        }
        if(divisor<0){
            flag=-flag;
            divisor=-divisor;
        }
        int result =0;
        while((dividend-divisor)>=0){
            if(flag>0&&result<Integer.MAX_VALUE||flag<0)
                result++;
            dividend=dividend-divisor;
        }
        if(flag<0){
            result=-result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegersSolution().divide(7,-3));
    }
}
