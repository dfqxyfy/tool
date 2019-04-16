package cn.letcode.color;

public class SortColorsSolution {
    public void sortColors(int[] nums){
        int left=0,read=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[read]==0){
                swap(nums,left,read);
                left++;
            }else if(nums[read]==1){
                swap(nums,left,read);
                left=read;
            }else if(nums[read]==2){
                swap(nums,right,read);
                right--;
            }
            read++;
        }
    }
    private void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {

    }
}
