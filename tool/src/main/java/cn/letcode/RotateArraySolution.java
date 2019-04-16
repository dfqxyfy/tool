package cn.letcode;

public class RotateArraySolution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (nums == null || (k = k % length) == 0) {
            return;
        }
        int[] newNums = new int[length];
        int start = length - k ;
        System.arraycopy(nums,start,newNums,0,k);
        System.arraycopy(nums,0,newNums,k,start);
        System.arraycopy(newNums,0,nums,0,length);
//        for (int i = 0; i < k; i++) {
//
//            newNums[i] = nums[start + i];
//        }
//        for (int i = 0; i < start; i++) {
//            newNums[k+i] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = newNums[i];
//        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArraySolution().rotate(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
