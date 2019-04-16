package cn.letcode.maximumsubarray;

public class MaximumSubarraySolution {

    public int maxSubArray(int[] nums) {
        int[] sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sumArray[i] = nums[i] + Math.max(sumArray[i-1],0);
        }
        int max = sumArray[0];
        for(int i = 1; i < sumArray.length; i++){
            max = Math.max(sumArray[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarraySolution().maxSubArray(nums));
    }
}
