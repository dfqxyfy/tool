package cn.letcode.mergesortedarray;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=nums1.length-1;
        int l1=m-1;
        int l2=n-1;
        while(l1>=0||l2>=0){
            if(l1>=0&&l2>=0 ){
                if( nums1[l1]>=nums2[l2]){
                    nums1[index]=nums1[l1];
                    l1--;
                }else{
                    nums1[index]=nums2[l2];
                    l2--;
                }
            }else if(l2>=0){
                nums1[index]=nums2[l2];
                l2--;
            }else if(l1>=0){
                nums1[index]=nums1[l1];
                l1--;
            }else{
                System.out.println("*****");
            }
            index--;
        }
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        new MergeSortedArray().merge(nums1,3,nums2,3);
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+"\t");
        }
    }

}
