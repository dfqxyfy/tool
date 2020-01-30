package cn.letcode.combinationsumii;

import java.util.*;

public class CombinationSumIISolution {
    private List<List<Integer>> resList = new ArrayList<>();
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        genList(0, 0, new ArrayList<>());
        Set<List<Integer>> sets = new HashSet<>();
        sets.addAll(resList);
        return new ArrayList<>(sets);
    }

    public void genList(int cur, int result, List<Integer> list) {
        for (int i = cur; i < candidates.length; i++) {
            if(i!=0&&candidates[i]==candidates[i-1]&&list.size()==0){
                continue;
            }
            result += candidates[i];
            list.add(candidates[i]);
            if (result == target) {
                resList.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            } else if (result > target) {
                list.remove(list.size() - 1);
                return;
            } else if (result < target) {
                genList(i + 1, result, list);
                result -= candidates[i];
                list.remove(list.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSumIISolution combinationSumIISolution = new CombinationSumIISolution();
        combinationSumIISolution.combinationSum2(candidates, target);
        List<List<Integer>> resList = combinationSumIISolution.resList;
        for (int i = 0; i < resList.size(); i++) {
            for (int j = 0; j < resList.get(i).size(); j++) {
                System.out.print(resList.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }
}
