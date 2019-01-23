package cn.letcode.ext;

public class BinarySearch {

    private int[] nums={1,2,3,4,5,7};
    private int target = 6;

    public int myse(int[] nums,int target){
        this.nums=nums;
        this.target=target;
        if(nums.length==0){
            return  -1;
        }
        return search(0,nums.length-1);
    }

    private int search(int left,int right){
        if(left==right){
            if(nums[left] == target){
                return left;
            }else{
                return -1;
            }
        }
        if(left>right){
            return -1;
        }
        if(target<nums[left] || target>nums[right]){
            return -1;
        }
        int mid=(left+right+1)/2;

        if(target < nums[mid]){
            right = mid-1;
        }else if(target > nums[mid]){
            left = mid+1;
        }else if(target == nums[mid]){
            return mid;
        }
        return search(left,right);
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,7,8};
        int target = 4;
        System.out.println(new BinarySearch().myse(nums,target));
    }
}
