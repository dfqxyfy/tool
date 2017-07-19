package cn.ccs.audition.algorithm;

import org.junit.Test;

/**
 * Created by chaichuanshi on 2017/7/13.
 */
public class BiSearch {

    int[] arrs = new int[]{1, 2,3,4, 7,8, 9};

    @Test
    public void BiSearch() {
        int i = search(arrs,4);
        System.out.println(i);
        i = search(arrs,5);
        System.out.println(i);
    }

    private int search(int[] arrs, int a) {
        int start = 0;
        int end = arrs.length-1;
        do{
            int count = (start+end)/2;
            System.out.println(count +" "+ start +" "+ end);
            if(arrs[count] == a) {
                return count;
            }else if(arrs[count] < a){
                start = count ;
            }else if(arrs[count] > a){
                end = count;
            }
        }while (start < (end-1));
        return -1;
    }
}
