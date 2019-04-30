package cn.letcode.pow;

public class PowOptimizeSolution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = x;
        if (n > 0) {
            double half = myPow(x, n / 2);
            if (n % 2 == 0) {
                res = half * half;
            } else {
                res = x * half * half;
            }
        } else if (n < 0) {
            double half = myPow(x, n / 2 * (-1));
            if (n % 2 == 0) {
                res = 1 / half / half;
            } else {
                res = 1 / x / half / half;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        double v = 0;//new PowOptimizeSolution().myPow(8.95371, -1);
        //v = new PowOptimizeSolution().myPow(1, -2147483648);
        v = new PowOptimizeSolution().myPow(2, -5);
        System.out.println(v);
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);

        double pow = Math.pow(0.00001, 2147483647);
        long l3 = System.currentTimeMillis();
        System.out.println(l3 - l2);
    }
}
