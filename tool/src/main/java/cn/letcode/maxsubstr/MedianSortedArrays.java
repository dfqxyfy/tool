package cn.letcode.maxsubstr;

public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i=0,j=0;
        int totLen = nums1.length+nums2.length;
        int len = 0;
        boolean lastAddNum1 = true;
        boolean num1NotOver = true;
        boolean num2NotOver = true;
        if(totLen%2==1){
            int pos = totLen/2 + 1;
            while(i<nums1.length && j<nums2.length){
                if(len == pos){
                    if(lastAddNum1){
                        System.out.println("i:"+i+" j:"+j);
                        return nums1[i];
                    }else{
                        System.out.println("i:"+i+" j:"+j);
                        return nums2[j];
                    }
                }

                len++;
                if(nums1[i] >= nums2[j]){
                    if(j<nums2.length && num2NotOver) {
                        if(j == nums2.length-1){
                            num2NotOver=false;
                        }else {
                            j++;
                        }
                        lastAddNum1 = false;
                    }else{
                        i++;
                        lastAddNum1 = true;
                    }
                }else if(nums1[i]<nums2[j]){
                    if(i<nums1.length && num1NotOver){
                        if(i == nums1.length-1) {
                            num1NotOver = false;
                        }else {
                            i++;
                        }
                        lastAddNum1 = true;
                    }else{
                        j++;
                        lastAddNum1 = false;
                    }
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4,5};
        System.out.println(new MedianSortedArrays().findMedianSortedArrays2(nums1,nums2));
        nums2 = new int[]{3};
        System.out.println(new MedianSortedArrays().findMedianSortedArrays2(nums1,nums2));
        nums2 = new int[]{3,4};
        System.out.println(new MedianSortedArrays().findMedianSortedArrays2(nums1,nums2));

        System.out.println(new MedianSortedArrays().findMedianSortedArrays3(nums1,nums2));
        nums2 = new int[]{3};
        System.out.println(new MedianSortedArrays().findMedianSortedArrays3(nums1,nums2));
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int i = -1, j = -1;
        int totLen = nums1.length + nums2.length;
        int len = 0;
        double sum= -1.0;
        int oddPos = totLen/2+1;
        if(totLen%2 == 1){
            while(i+1<nums1.length || j+1<nums2.length) {
                if (i + 1 >= nums1.length) {
                    j++;
                    sum = nums2[j];
                } else if (j + 1 >= nums2.length) {
                    i++;
                    sum = nums1[i];
                } else {
                    if (nums1[i + 1] < nums2[j + 1]) {
                        i++;
                        sum = nums1[i];
                    } else {
                        j++;
                        sum = nums2[j];
                    }
                }
                len++;
                if (len == oddPos) {
                    return sum;
                }
            }
        }else{
            int evenPosLeft = totLen/2;
            int evenPosRight = totLen/2+1;
            double temp = 0;
            while(i+1<nums1.length || j+1<nums2.length) {
                if (i + 1 >= nums1.length) {
                    j++;
                    sum = nums2[j];
                } else if (j + 1 >= nums2.length) {
                    i++;
                    sum = nums1[i];
                } else {
                    if (nums1[i + 1] < nums2[j + 1]) {
                        i++;
                        sum = nums1[i];
                    } else {
                        j++;
                        sum = nums2[j];
                    }
                }
                len++;
                if (len == evenPosLeft) {
                    temp+=sum;
                }
                if(len == evenPosRight){
                    temp+=sum;
                    return temp/2;
                }
            }
        }
        return sum;
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2){
        int totLen = nums1.length+nums2.length;
        boolean isOdd = totLen%2 == 1;
        double sum = 0.0;
        int i=-1;
        int j=-1;
        int temp = 0;
        int len = 0;
        while(i+1<nums1.length||j+1<nums2.length){
            if(i+1>=nums1.length){
                j++;
                temp = nums2[j];
            }else if(j+1>=nums2.length){
                i++;
                temp = nums1[i];
            }else{
                if(nums1[i+1]<nums2[j+1]){
                    i++;
                    temp=nums1[i];
                }else{
                    j++;
                    temp=nums2[j];
                }
            }
            len++;
            if(isOdd){
                if(len == totLen/2+1){
                    return temp;
                }
            }else{
                if(len == totLen/2){
                    sum = temp;
                }
                if(len == totLen/2+1){
                    sum += temp;
                    return sum/2;
                }
            }
        }
        return sum;
    }
}
