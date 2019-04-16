package cn.ccs.optimize;

import java.util.ArrayList;
import java.util.List;

public class MyTestOptimize {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10000000;i++){
            list.add(i);
        }

        long t1 = System.currentTimeMillis();
        int x = list.size();
        int count1=0;
        int count2=0;
        System.out.println(x);
        //synchronized (MyTestOptimize.class){
        for(int i=0;i<x;i++){
                try {
                    int c = list.get(i) + 3;
                    count1+=c;
                }catch (Exception e){

                }

//            boolean b = true;
//            if(b){
//                list = null;
//            }else{
//                list = null;
//            }
            }
        //}
        System.out.println(count1);
        long t2 = System.currentTimeMillis();
        for(int i=0;i<x;i++){
            int c = list.get(i)+3;
            count2+=c;
//            boolean b = true;
//            list=(b==true?null:null);
        }
        System.out.println(count2);
        long t3 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println(t3-t2);
    }

}
