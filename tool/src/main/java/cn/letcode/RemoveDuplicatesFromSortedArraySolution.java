package cn.letcode;

public class RemoveDuplicatesFromSortedArraySolution {
    public int removeDuplicates(int[] nums) {
        if(nums==null){
            return 0;
        }
        if(nums.length==0){
            return 0;
        }
        int curVal=nums[0];
        int curPos=0;

        for(int i=1;i<nums.length;i++){
            if(curVal == nums[i]){
                continue;
            }else {
                curPos++;
                nums[curPos] = nums[i];
                curVal=nums[curPos];
            }
        }
        return curPos+1;
    }

    public static void main(String[] args) {
        int is[] = new int[]{-1,0,0,0,0,3,3};
        int pos = new RemoveDuplicatesFromSortedArraySolution().removeDuplicates(is);
        System.out.println(pos);
        for(int i=0;i<is.length;i++){
            System.out.println(is[i]);
        }
    }
}
