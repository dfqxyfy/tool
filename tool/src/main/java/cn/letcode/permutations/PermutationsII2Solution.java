package cn.letcode.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII2Solution {

    public void traverse(List<List<Integer>> resultList, List<Integer> current, int[] nums, boolean[] used) {
        if( current.size() == nums.length )
            resultList.add(new ArrayList<Integer>(current));
        else{
            for(int i = 0; i < nums.length; i++) {
                if( used[i] || ( i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) ) // remove duplicate
                    continue;
                current.add(nums[i]);
                used[i] = true;
                traverse(resultList, current, nums, used);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // sort is necessary
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        traverse(resultList, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        PermutationsII2Solution permutationsSolution = new PermutationsII2Solution();
        List<List<Integer>> permute = permutationsSolution.permuteUnique(nums);
        permute.forEach(l -> {
            l.forEach(n -> {
                System.out.print(n + "\t");
            });
            System.out.println();
        });

        boolean[] used = new boolean[5];
        for(int i=0;i<used.length;i++){
            System.out.println(used[i]);
        }
    }
}
