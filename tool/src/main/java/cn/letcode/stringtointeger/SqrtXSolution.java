package cn.letcode.stringtointeger;

public class SqrtXSolution {


    public int mySqrt(int x) {
        if(x==1){
            return 1;
        }
        int min = 0;
        int max = x;
        int temp = 0;

        do {
            if (max - min == 1 || max - min == 0) {
                return min;
            }
            temp = (min + max) / 2;
            if (bigThanX(temp, x)) {
                max = temp;
            } else {
                min = temp;
            }
        } while (min < max);
        return min;
    }

    private boolean bigThanX(int val, int res) {
        if(val>46340){
            return true;
        }
        if(val*val>res){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int i = new SqrtXSolution().mySqrt(2147395600);
        System.out.println(i);

        System.out.println(Math.sqrt(Integer.MAX_VALUE));
    }
}
