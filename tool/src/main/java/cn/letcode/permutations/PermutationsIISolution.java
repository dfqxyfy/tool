package cn.letcode.permutations;

import java.util.*;

public class PermutationsIISolution {
    List<List<Integer>> resList = new ArrayList<>();
    int len = 0;

    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        permute(nums, new ArrayList<>());
        Set<List<Integer>> set = new HashSet<>(resList);
        return new ArrayList<List<Integer>>(set);
    }

    public void permute(int[] nums, List<Integer> list) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> addList = new ArrayList<>(list);
            addList.add(nums[i]);
            if (addList.size() == len) {
                resList.add(addList);
                return;
            }
            int[] tempArr = new int[nums.length - 1];
            if (i > 0) {
                System.arraycopy(nums, 0, tempArr, 0, i);
            }
            if (i < nums.length) {
                System.arraycopy(nums, i + 1, tempArr, i, tempArr.length - i);
            }
            permute(tempArr, addList);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        PermutationsIISolution permutationsSolution = new PermutationsIISolution();
        List<List<Integer>> permute = permutationsSolution.permuteUnique(nums);
        permute.forEach(l -> {
            l.forEach(n -> {
                System.out.print(n + "\t");
            });
            System.out.println();
        });
    }
}
