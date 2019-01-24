package cn.letcode;

import java.util.*;

public class CombinationSumSolution {
    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int i = 1; i <= target; i++) {
            combinationSum(candidates,target,new ArrayList<>(), i);
        }
        return notRepeated();
    }


    public void combinationSum(int[] candidates, int target ,List<Integer> list, int num) {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            count += candidates[list.get(i)];
            stringBuilder.append(list.get(i)).append(" ");
        }
        System.out.println("process -- "+stringBuilder);
        if (count == target) {
            List<Integer> res = new ArrayList<>();
            res.addAll(list);
            resultList.add(res);
        }
        if (count >= target) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            list.add(i);
            int c = list.size();
            for (int j = 0; j < num; j++) {
                combinationSum(candidates,target,list, j);
            }
            list.remove(c-1);
        }
    }


    private List<List<Integer>> notRepeated(){
        resultList.forEach(list->{
            Collections.sort(list);
        });
        List<List<Integer>> dealResult = new ArrayList<>();
        Set<String> sets = new HashSet<>();
        resultList.forEach(list->{
            StringBuilder strb = new StringBuilder();
            list.forEach(l->{
                strb.append(l);
            });
            if(!sets.contains(strb.toString())){
                sets.add(strb.toString());
                dealResult.add(list);
            }
        });
        return dealResult;
    }


    public static void main(String[] args) {
        int[] can = {2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = new CombinationSumSolution().combinationSum(can, target);
        lists.forEach(l->{
            l.forEach(i->{
                System.out.print(can[i]+" ");
            });
            System.out.println();
        });
    }


}
