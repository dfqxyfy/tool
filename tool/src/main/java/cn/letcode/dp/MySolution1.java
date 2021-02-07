package cn.letcode.dp;

public class MySolution1 {

//    int[] a=new int[]{1,-1,2,3,-1,};
//    int[] a=new int[]{-10,1,2,3,4,-5,-23,3,7,-21};
    int[] a=new int[]{10,1,2,3,4,-5,-23,3,7,-21};

    int dp(int n){
        if(n<=0){
            return a[0];
        }
        int result = Integer.MIN_VALUE;
        result = Math.max(a[n],dp(n-1)+a[n]);
        return result;
    }
    public static void main(String[] args) {
        MySolution1 mySolution1 = new MySolution1();
        Integer max = 0;
        for(int i=0;i<mySolution1.a.length;i++) {
            int dp = mySolution1.dp(i);
            //System.out.println(dp);
            max = Math.max(dp,max);
        }
        System.out.println(max);
        System.out.println(mySolution1.for3Time());
        System.out.println(mySolution1.for2Time());
    }

    public int for3Time(){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                int val = 0;
                for(int k=i;k<=j;k++){
                    val+=a[k];
                }
                max=Math.max(val,max);
            }
        }
        return max;
    }

    public int for2Time(){
        int[] sum = new int[a.length];
        for(int i=0;i<a.length;i++){
            if(i==0){
                sum[0]=a[0];
            }else{
                sum[i]=sum[i-1]+a[i];
            }
            System.out.print(i+":"+sum[i]+",");
        }
        System.out.println();

        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                if(i-1<=0){
                    max=Math.max(max,sum[j]-0);
                }else {
                    max = Math.max(max, sum[j] - sum[i - 1]);
                }
            }
        }
        return max;
    }
}
