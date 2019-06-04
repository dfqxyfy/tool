package cn.letcode.climbingstairs;

public class ClimbingStairs2Solution {
    public int climbStairs(int n) {

        return climb_Stairs(0,n);
    }
    int climb_Stairs(int i,int n){
        if(i>n){
            return 0;
        }else if(i==n){
            return 1;
        }
        return climb_Stairs(i+1,n)+climb_Stairs(i+2,n);
    }


    public static void main(String[] args) {
        int i = new ClimbingStairs2Solution().climbStairs(44);
        System.out.println(i);
    }
}
