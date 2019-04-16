package cn.letcode.color;

public class Series {
    public int seri(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int[] nums=new int[n+1];
        nums[0]=0;
        nums[1]=1;
        if(n>=2){
            for(int i=2;i<=n;i++){
                nums[i]=nums[i-1]+nums[i-2];
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        for(int i=0;i<=15;i++) {
            System.out.println(new Series().seri(i));
        }
    }
}
