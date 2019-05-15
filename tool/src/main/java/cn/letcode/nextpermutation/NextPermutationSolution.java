package cn.letcode.nextpermutation;

import java.util.Arrays;

public class NextPermutationSolution {
    public void nextPermutation(int[] nums) {
        int first = nums.length;
        int second = nums.length-1;
        for (int i = nums.length - 1; i > 0; i--) {
            if(nums[i-1]<nums[i]){
                first=i-1;
                break;
            }
        }
        for(int i=first+1;i<nums.length;i++){
            if(nums[i]<=nums[first]){
                break;
            }
            second=i;
        }
        if (first != nums.length) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        } else {
            Arrays.sort(nums);
        }

        for (int i = first+1 ; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }


        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{1,2,3,4,5};
        int[] nums = new int[]{1, 3, 2};

        //1,5,8,5,1,3,4,5,6,7
        nums = new int[]{1,5,8,4,7,6,5,3,1};
        //nums = new int[]{4, 2, 0, 2, 3, 2, 0};
        nums = new int[]{1, 2, 3};
        nums = new int[]{1,5,1};
        new NextPermutationSolution().nextPermutation(nums);
    }
}
