package cn.ccs.sort;

import java.util.Comparator;
import java.util.TreeSet;

public class MyTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return -1;
                }else if(o1<o2){
                    return 1;
                }
                return 0;
            }
        });
        for(int i=10;i>0;i--){
            set.add(i+10);
        }
        set.remove(set.last());
        for(Integer i:set){
            System.out.println(i);
        }
    }
}
