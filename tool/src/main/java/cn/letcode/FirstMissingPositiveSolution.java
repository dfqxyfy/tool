package cn.letcode;

import java.util.TreeSet;

public class FirstMissingPositiveSolution {
    public int firstMissingPositive(int[] nums) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0){
                continue;
            }else{
                treeSet.add(nums[i]);
            }
        }
        if(treeSet.size()==0){
            return 1;
        }
        for(int i=0;;i++){
            Integer first = treeSet.pollFirst();
            if (first!=null && (i + 1) != first) {
                return (i + 1);
            }else if(first==null){
                return i+1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        //nums=new int[]{0};
        int i = new FirstMissingPositiveSolution().firstMissingPositive(nums);
        System.out.println(i);
    }
}
