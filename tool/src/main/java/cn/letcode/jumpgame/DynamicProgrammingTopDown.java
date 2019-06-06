package cn.letcode.jumpgame;

public class DynamicProgrammingTopDown {
    Index[] memo;
    public boolean canJump(int[] nums) {
        memo=new Index[nums.length];
        for(int i=0;i<memo.length;i++){
            memo[i]=Index.UNKNOWN;
        }
        jump(0,nums);
        return memo[nums.length-1].val();
    }

    private boolean jump(int pos,int[] nums){
        if(memo[pos]!=Index.UNKNOWN){
            return memo[pos].val();
        }
        if(pos==nums.length-1){
            memo[pos]=Index.TRUE;
            return true;
        }
        for(int i=pos+1;i<=pos+nums[pos] && i<nums.length;i++){
            if(jump(i,nums)){
                return true;
            }
        }
        memo[pos]=Index.FALSE;
        return false;
    }

    public static void main(String[] args) {

//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        int[] nums = new int[]{3, 2, 1, 0, 0, 4};
//        nums = new int[]{2, 0, 0};
//        nums = new int[]{2, 3, 1, 1, 4};
        //nums=new int[]{0};
        nums=OptJumpGameSolution.getValFromFile();
        boolean b = new DynamicProgrammingTopDown().canJump(nums);
        System.out.println(b);
    }
}

enum Index {
    TRUE(true), FALSE(false), UNKNOWN(false);
    boolean b;
    private Index(boolean b){
        this.b=b;
    }

    public boolean val(){
        return b;
    }
}
