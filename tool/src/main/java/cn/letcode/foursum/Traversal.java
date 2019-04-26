package cn.letcode.foursum;

import java.util.ArrayList;
import java.util.List;

public class Traversal {
    public int traversalTimes(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    int count = 0;

    public void run(int[] nums, int count) {
        this.nums = nums;
        this.count = count;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            recursion(i, count, list);

        }
    }

    int countNum = 0;

    public void recursion(int start, int target, List<Integer> list) {
        if (target == 0) {
            countNum++;
            return;
        }
        for (int i = start; i <= nums.length - target; i++) {
            List<Integer> list2 = new ArrayList<>(list);
            list2.add(nums[i]);
            for(int j=0;j<list2.size();j++){
                System.out.print(list2.get(j)+"\t");
            }
            System.out.println();
            recursion(i + 1, target - 1, list2);
        }
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        traversal.recursion(0, 4, new ArrayList<>());
        System.out.println(traversal.countNum);

    }
}
