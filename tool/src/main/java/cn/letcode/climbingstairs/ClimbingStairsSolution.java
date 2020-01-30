package cn.letcode.climbingstairs;

public class ClimbingStairsSolution {
    int count=0;
    int top=0;
    public int climbStairs(int n) {
        top=n;
        climb(0);
        return count;
    }
    void climb(int n){
        if(n>top){
            return;
        }
        if(n==top){
            count++;
        }
        if(n<top){
            climb(n+1);
            climb(n+2);
        }
    }

    public static void main(String[] args) {
        int i = new ClimbingStairsSolution().climbStairs(44);
        System.out.println(i);
    }
}
