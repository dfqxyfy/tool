package cn.letcode.twosum;

import java.util.HashMap;
import java.util.Map;

class TwoSumSolution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        int[] resInt = new int[2];
        for(int i=0;i<nums.length;i++){
            if(numsMap.get(nums[i])!=null){
                resInt[0]=numsMap.get(nums[i]);
                resInt[1]=i;
                return resInt;
            }
            numsMap.put(target - nums[i],i);
        }
        return resInt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15,8,8};
        int[] ints = twoSum(nums, 16);
        System.out.println(ints[0]+" -- "+ints[1]);
    }
}