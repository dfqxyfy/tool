package cn.ccs.hash;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TestSortMap {
    private SortedMap<Integer,String> mysortMap = new TreeMap<>();

    public static void main(String[] args) {
        SortedMap<Integer,String> mysortMap = new TreeMap<>();
        for(int i = 0;i<10;i++,i++){
            int i1 = 'a' + i;
            char c = Character.forDigit(i1, 10);
            mysortMap.put(i,Character.toString(c));
            //System.out.println(mysortMap.get(i));
        }

        NavigableMap<Integer, String> integerStringNavigableMap = ((TreeMap<Integer, String>) mysortMap).tailMap(3, false);
        integerStringNavigableMap.forEach(
                (k,v)->{
                    System.out.print(k+"\t");
                    System.out.println(v);
                }
        );
    }

}
