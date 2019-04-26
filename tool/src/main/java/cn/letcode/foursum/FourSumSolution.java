package cn.letcode.foursum;

import java.util.*;

public class FourSumSolution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> sets = new HashSet<>();
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int start=j+1;
                int end=nums.length-1;
                while(start<end){
                    int sum = nums[i]+nums[j]+nums[start]+nums[end];
                    if(sum==target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        sets.add(list);
                        start++;
                    }else if(sum<target){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(sets);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> lists = new FourSumSolution().fourSum(nums, 0);
        for (List<Integer> l : lists) {
            for (Integer i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
