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
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
