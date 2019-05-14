package cn.ccs.map;

import java.util.HashMap;
import java.util.Map;

public class MyMap {
    public static void main(String[] args) {
        Map<Object,String> map = new HashMap<>();
        map.put(new Integer(1),"aa");
        map.put(new Integer(1),"bb");
        map.put(new Object(),"bb");
        map.put(new Object(),"bb");
        System.out.println(map.size());

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<String, String> myMap = new HashMap<>();
        String keyA = "A";
        String keyB = "B";
        String keyC = "C";
        String keyD = "D";
        String keyE = "E";
        String keyF = "F";
        String keyG = "G";
        String keyH = "H";
        myMap.put(keyA, "str01A");
        //myMap.put(keyB, "str01B");
        myMap.put(keyC, "str01C");

        System.out.println("myMap initial content:"+ myMap);

        myMap.merge(keyA, "merge01", String::concat);
        myMap.merge(keyD, "merge01", String::concat);
        System.out.println("Map merge demo content:"+ myMap);

        String s = "";


        System.out.println("*******");
        System.out.println(myMap);
        myMap.merge(keyB,"bbbb",(v1,v2)->v1);

        System.out.println(myMap);

    }
}
