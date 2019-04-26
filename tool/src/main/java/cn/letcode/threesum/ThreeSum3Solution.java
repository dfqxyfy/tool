package cn.letcode.threesum;

import java.util.*;

public class ThreeSum3Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int l = i + 1;
                int h = nums.length - 1;
                while (l < h) {
                    if (nums[i] + nums[l] + nums[h] == 0) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[h]));
                        while (l < h && nums[l] == nums[l + 1]) {
                            ++l;
                        }
                        while (l < h && nums[h] == nums[h - 1]) {
                            --h;
                        }
                        ++l;
                        --h;
                    } else if (nums[i] + nums[l] + nums[h] > 0) {
                        --h;
                    } else {
                        ++l;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        nums = new int[]{1, -1};
        nums = new int[]{-1, 0, 1, 2, -1, -4};
        //nums = new int[]{0,0,0};
        List<List<Integer>> lists = new ThreeSum3Solution().threeSum(nums);
        for (List<Integer> l : lists) {
            for (Integer i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

    }
}
