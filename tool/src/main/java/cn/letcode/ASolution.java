package cn.letcode;

public class ASolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        int i=0;
        int j=0;
        int flag = 0;
        do{
            if((i<nums1.length)&&(j>=nums2.length||nums1[i]<=nums2[j])){
                i++;
                flag =0;
            }else if((j<nums2.length)&&(i>=nums1.length||nums1[i]>nums2[j])){
                j++;
                flag = 1;
            }
        }while((i+j)<len/2+1);

        System.out.println("i="+i+" j="+j);
        if(len%2==0){
            int result = 0;
            if(i==0){
                result+=nums2[j-1];
            }else if(j==0){
                result+=nums1[i-1];
            }else if(flag == 0){
                result = nums1[i-1]+nums2[j-1];
            }else if(flag == 1){
                result = nums1[i-1]+nums2[j-1];
            }
            return (double)(result)/2;
        }else{
            if(flag == 0){
                return nums1[i-1];
            }else{
                return nums2[j-1];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2,3};
        System.out.println(new ASolution().findMedianSortedArrays(nums1,nums2));
    }
}
