package cn.letcode.threesumclosest;

import java.util.Arrays;

public class ThreeSumClosestCcsSolution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums == null || nums.length < 3) {
            throw new RuntimeException();
        }
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - result) > Math.abs(target - sum)) {
                    System.out.println(target - result);
                    result = sum;
                }
                if(sum<target) {
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        nums = new int[]{1, 1, 1, 0};
        nums = new int[]{1, 1, -1, -1, 3};
        int target = -1;

        nums = new int[]{1,2,4,8,16,32,64,128};
        target = 82;
        int n = new ThreeSumClosestCcsSolution().threeSumClosest(nums, target);
        System.out.println(n);
    }
}
