package cn.letcode.searchinrotatedsortedarray;

public class SearchInRotatedSortedArraySolution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (end >= start) {
            int mid = (start + end + 1) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (start == end) {
                return -1;
            }
            if (nums[mid] >= nums[start]) {
                //left ordered
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid-1;
                } else if (target > nums[end] && target < nums[start]) {
                    return -1;
                } else {
                    start = mid+1;
                }
            } else if (nums[mid] <= nums[end]) {
                //right ordered
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid+1;
                } else if (target > nums[end] && target < nums[start]) {
                    return -1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 1;
        nums = new int[]{1, 3};
        target = 0;

        nums = new int[]{1, 3};
        target = 1;
        //nums = new int[]{1};
        long l1 = System.currentTimeMillis();
        int s = new SearchInRotatedSortedArraySolution().search(nums, target);
        long l2 = System.currentTimeMillis();
        System.out.println(s);
        //System.out.println(l2-l1);
    }
}
