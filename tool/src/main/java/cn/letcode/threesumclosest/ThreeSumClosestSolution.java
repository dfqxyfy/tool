package cn.letcode.threesumclosest;

import java.util.Arrays;

public class ThreeSumClosestSolution {
    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
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

        nums = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
        target = 82;
        int n = new ThreeSumClosestSolution().threeSumClosest(nums, target);
        System.out.println(n);
    }
}
