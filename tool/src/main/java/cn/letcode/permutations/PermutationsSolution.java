package cn.letcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationsSolution {
    List<List<Integer>> resList = new ArrayList<>();
    int len = 5;

    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        permute(nums, new ArrayList<>());
        return resList;
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
        int[] nums = new int[]{1, 2, 3, 4, 5};
        PermutationsSolution permutationsSolution = new PermutationsSolution();
        permutationsSolution.permute(nums);
        permutationsSolution.resList.forEach(l -> {
            l.forEach(n -> {
                System.out.print(n + "\t");
            });
            System.out.println();
        });
    }
}
