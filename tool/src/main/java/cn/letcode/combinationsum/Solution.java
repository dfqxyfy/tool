package cn.letcode.combinationsum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<Integer>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        find(candidates, 0, target);
        return res;
    }
    
    void find(int[] nums, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
        } else if (target > 0) {
            for (int i = start; i < nums.length; i++) {
                cur.add(nums[i]);
                find(nums, i, target-nums[i]);
                cur.remove(cur.size()-1);
            }
        }
    }
}