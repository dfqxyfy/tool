package cn.letcode;

public class PlusOneSolution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;

        for(int i=len-1;i>=0;i--){
            int temp = digits[i]+carry;
            if(carry==0){
                break;
            }
            digits[i]=temp%10;
            if(temp>=10){
                carry=1;
            }else{
                carry=0;
            }
            if(i==0 && carry==1){
                int[] nums = new int[len+1];
                nums[0]=1;
                System.arraycopy(digits,0,nums,1,len);
                return nums;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9};
        int[] ints = new PlusOneSolution().plusOne(digits);
        for(int i=0;i<ints.length;i++){
            System.out.print(ints[i]+"\t");
        }


    }
}
