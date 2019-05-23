package cn.letcode.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res(candidates, 0, 0,target, new ArrayList<>());
        return resultList;
    }

    public void res(int[] candidates, int curVal,int index, int target,List<Integer> list) {

        for (int i = index; i < candidates.length; i++) {

            List<Integer> nextList = new ArrayList<>();
            list.forEach(l -> {
                nextList.add(l);
            });
            int temp = curVal + candidates[i];
            nextList.add(candidates[i]);
            if (temp < target) {
                res(candidates, temp,i, target, nextList);
            } else if (temp > target) {
                return;
            } else if (temp == target) {
                resultList.add(nextList);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = new CombinationSum().combinationSum(candidates, target);
        System.out.println("********");
        lists.forEach(list -> {
            list.forEach(i -> {
                System.out.print(i + "\t");
            });
            System.out.println();
        });


    }
}
