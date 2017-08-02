package cn.social;

import org.junit.Test;

import java.util.*;

/**
 * Created by ccs on 2017/7/12.
 */
public class RandomAdd1 {
    private static final int PERSON_NUM = 10000;
    private static final int PERSON_COUNT = 10000;

    int[] personArray = new int[PERSON_NUM];
    @Test
    public void randomAdd(){
        for(int i = 0;i<PERSON_NUM;i++){
            personArray[i] = 100;
        }
        System.out.println();
        System.out.println(personArray.length);
        for(int i = 0;i<PERSON_NUM;i++){
            for(int j= 0;j<PERSON_COUNT;j++){
                if(personArray[i]<=0){
                   // break;
                }
                personArray[i]+=randomChange();
            }
        }
        List<Integer> list = new ArrayList();
        for(int i= 0;i<PERSON_NUM;i++){
            list.add(personArray[i]);
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(Object o :list){
            System.out.print(o+" ");
        }
    }

    private Random random = new Random();
    private int randomChange(){
        if(random.nextInt()%2==0){
            return -1;
        }else{
            return 1;
        }
    }
}
