package cn.letcode.findfirstandlastpositionofelementinsortedarray;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int i = binarySearch(nums, target, true);
        int j = binarySearch(nums, target, false);

        return new int[]{i, j};
    }

    private int binarySearch(int[] nums, int target, boolean minthab) {
        int start = 0;
        int end = nums.length - 1;
        boolean hasFound = false;
        int pos = -1;
        while (start <= end) {
            if ( hasFound == false && (target < nums[start] || target > nums[end])) {
                return -1;
            }
            int mid = (start + end + 1) / 2;
            if (target < nums[mid]) {
                if (hasFound && minthab)
                    return pos;
                end = mid - 1;
            } else if (target > nums[mid]) {
                if (hasFound && !minthab) {
                    return pos;
                }
                start = mid + 1;
            } else if (target == nums[mid]) {
                hasFound = true;
                pos = mid;
                if (minthab) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target = 1;
//        nums=new int[]{5,7,7,8,8,10};
//        target=8;
        final int[] ints = new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
