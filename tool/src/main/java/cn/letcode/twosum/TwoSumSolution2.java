package cn.letcode.twosum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TwoSumSolution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numsMap.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(numsMap.containsKey( target-nums[i])&&numsMap.get(target-nums[i]) != i){
                return new int[]{i,numsMap.get(target-nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum data");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15,8};
        int[] ints = new TwoSumSolution2().twoSum(nums, 9);
        System.out.println(ints[0]+" -- "+ints[1]);
        Set<Character> sets = new HashSet<>();
    }
}