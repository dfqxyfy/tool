package cn.letcode.searchinrotatedsortedarray;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        // find the turning point, which is O(lgn);
        int index = findTurningPoint(nums);
        int start = 0;
        int end = nums.length - 1;
        int target1 = binarySearch(nums, 0, index - 1, target);
        int target2 = binarySearch(nums, index, end, target);

        return target1 != -1 ? target1 : target2;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {

        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }


    public int findTurningPoint(int[] nums) {
        int length = nums.length;
        int tail = length - 1;
        int head = 0;
        int mid;
        while (tail - head > 1) {
            mid = (head + tail) / 2;
            if (nums[mid] > nums[head])
                head = mid;
            else
                tail = mid;
        }
        return nums[head] < nums[tail] ? head : tail;
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
        int s = new Solution().search(nums, target);
        long l2 = System.currentTimeMillis();
        System.out.println(s);
        //System.out.println(l2-l1);
    }
} 