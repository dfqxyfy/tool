package cn.letcode.jumpgame;

public class BacktrackingSolution {
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = furthestJump; nextPosition >position ; nextPosition--) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,0,4};
        nums=new int[]{2,0,0};

        boolean b = new BacktrackingSolution().canJump(nums);
        System.out.println(b);
    }
}
