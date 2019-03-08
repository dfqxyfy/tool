package cn.ccs.sort;

public class Merge2Sort {

    public void sort(int[] a){
        int step = 1;
        do{
            for(int i=0;i<a.length;i+=step){
                for(int j=i*step;j<a.length/(2*step);j++){
                    for(int k=j*step;k<step*2;k++){
                        if((k+step) >= a.length ) {
                            break;
                        }
                        if (a[k] > a[k + step]) {
                            int temp = a[k];
                            a[k] = a[k + step];
                            a[k + step] = temp;
                        }
                    }
                }
                for(int t:a){
                    System.out.print(t+"\t");
                }
                System.out.println();
                if(a.length/(2*step)<=0){
                    break;
                }
            }
            step*=2;
        }while(step<=a.length);
    }

    private void merge(int[] a,int start,int end){
        if(start==end){
            return;
        }
        int count = end - start;
        int pre = start;
        int mid = start+(end - start)/2;
        int aft = mid+1;
        int[] temp = new int[end - start];
        for(int k=0;k<count;k++){
            if(a[pre] > a[aft]){
                temp[k] = a[pre];
                pre++;
            }else{
                temp[k] = a[aft];
                aft++;
            }
        }
        for(int i=0;i<a.length;i++){
            a[i]=temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,3,5,4,2};
        new Merge2Sort().sort(a);
        for(int t:a){
            System.out.println(t);
        }
    }
}
