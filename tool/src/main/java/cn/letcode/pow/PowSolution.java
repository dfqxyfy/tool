package cn.letcode.pow;

public class PowSolution {
    public double myPow(double x, int n) {
        boolean positive = true;
        if(n<0){
            positive = false;
            n*=-1;
        }
        if(n==0)
            return 1;
        double num=1;
        for(int i=0;i<n;i++){
            num *= x;
        }
        if(positive){
            return num;
        }else{
            return 1/num;
        }
    }

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        double v = new PowSolution().myPow(0.00001, 2147483647);
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);

        double pow = Math.pow(0.00001, 2147483647);
        long l3 = System.currentTimeMillis();
        System.out.println(l3-l2);
    }

}
