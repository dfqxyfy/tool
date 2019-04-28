package cn.letcode.my;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    int[] nums=new int[]{1,2,3,4,5,6,7};
    int count=3;


    private void startRecursion(int start,int count,List<Integer> list){
        if(count<0){
            for(Integer l:list){
                System.out.print(l+"\t");
            }
            System.out.println();
            return;
        }
        for(int i=start;i<nums.length-count;i++){
            List<Integer> list2 = new ArrayList<>(list);
            list2.add(nums[i]);
            startRecursion(i+1,count-1,list2);
        }
    }

    public static void main(String[] args) {
        //new Recursion().recu();
        new Recursion().startRecursion(0,2,new ArrayList<>());
    }
}
