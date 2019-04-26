package cn.letcode.threesum;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreeSum2Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }

        }
        return new ArrayList<>(res);

    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        nums = new int[]{1, -1};
//        nums = new int[]{-1, 0, 1, 2, -1, -4};
//        //nums = new int[]{0,0,0};
//        nums = new int[]{-6,1,2,3,4,5};
//        //List<List<Integer>> lists = new ThreeSum2Solution().threeSum(nums);
//        List<List<Integer>> lists = new ThreeSumCcsCopySolution().threeSum(nums);
//        for (List<Integer> l : lists) {
//            for (Integer i : l) {
//                System.out.print(i + "\t");
//            }
//            System.out.println();
//        }


        Set<List<Integer>> res = new HashSet<>();


        List<Integer> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList(new Integer[]{1,3,5}));


        System.out.println(list1.hashCode());
        List<Integer> list2 = new ArrayList<>();//Arrays.asList(new Integer[]{1,3,5});
        list2.addAll(Arrays.asList(new Integer[]{1,3,5}));
        System.out.println(list2.hashCode());
        res.add(list1);
        res.add(list2);
        System.out.println(res.size());



        Map<AtomicInteger,Integer> map = new HashMap<>();
        map.put(new AtomicInteger(111),1);
        map.put(new AtomicInteger(111),1);
        //map.put("110000",1);
        //map.put(new Integer(110000),1);
        System.out.println(map.size());
    }
}
class Person{

}
