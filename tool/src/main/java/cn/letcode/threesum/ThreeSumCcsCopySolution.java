package cn.letcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumCcsCopySolution {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> sumList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i-1]==nums[i]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(k>j) {
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> result=Arrays.asList(new Integer[]{nums[i],nums[j],nums[k]});
                    sumList.add(result);
                    j++;
                    while(nums[j-1]==nums[j] && k>j){
                        j++;
                    }
                    while(nums[k-1]==nums[k] && k>j){
                        k--;
                    }
                }else if(nums[i]+ nums[j]+nums[k] >0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return sumList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-6,0,0,0,0,1,1,2,3,4,5,5};
        nums = new int[]{-6,1,1,2,3,4,5,5};
        List<List<Integer>> lists = new ThreeSumCcsCopySolution().threeSum(nums);
        for (List<Integer> l : lists) {
            for (Integer i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
