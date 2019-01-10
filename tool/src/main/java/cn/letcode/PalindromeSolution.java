package cn.letcode;

public class PalindromeSolution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int sum = 0;
        int temp = x;
        do {
            sum = (sum*10) + temp % 10;
        } while ((temp = temp/ 10) != 0);
        System.out.println(sum);
        if(sum==x){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new PalindromeSolution().isPalindrome(-353);
        System.out.println(b);
    }
}
