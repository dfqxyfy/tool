package cn.letcode.subsets;

import java.util.ArrayList;
import java.util.List;

public class SubsetsSolution {

    public List<List<Integer>> subsets(int[] array) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> solutions = new ArrayList<>();
        makeSubsets(array, 0, solutions, new ArrayList<>());
        return solutions;
    }

    private void makeSubsets(int[] array, int i, List<List<Integer>> solutions, List<Integer> list) {
        if (i == array.length) {
            solutions.add(new ArrayList<>(list));
            return;
        }
        makeSubsets(array, i + 1, solutions, list); // don't use array[i]
        list.add(array[i]); // use array[i]
        makeSubsets(array, i + 1, solutions, list);
        list.remove(list.size() - 1);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = new SubsetsSolution().subsets(nums);
        //System.out.println(subsets.size());
        subsets.forEach(l-> System.out.println(l));
    }
}
