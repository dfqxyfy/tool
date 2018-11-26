package cn.ccs.btrace;

import java.util.HashMap;
import java.util.Map;

public class DemoThread {

    private String aa = "10000";
    public String getA(){
        return aa;
    }

    public static void main(String[] args) {
        DemoThread a = new DemoThread();
        System.out.println("aaa");
        Map map = new HashMap<>();
        for(;;) {
            try {
                long t1 = System.nanoTime();
                String a1 = a.getA();
                long t2= System.nanoTime();
                String key = "cost " + (t2-t1) + " ms  "+ a1;
                String value = key;
                System.out.println(key);
                map.put(key,value);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

