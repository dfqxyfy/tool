package cn.letcode.searchinrotatedsortedarray;

public class BinarySearch {

    public int binaryS(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end + 1) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[start] || target > nums[end]) {
                return -1;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1 ;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2,3,5,7};
        int target = 1;
        target=7;
        int i = new BinarySearch().binaryS(nums, target);
        System.out.println(i);
    }
}
