package cn.sys;

import java.util.concurrent.ArrayBlockingQueue;

public class MyEnv {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());

        ArrayBlockingQueue<String> myqueue = new ArrayBlockingQueue<>(5);

        for(int i=0;i<5;i++){
            myqueue.add("aaaa"+i);
        }
        String str;
        while(true){
            try {
                //str=myqueue.take();
                str=myqueue.poll();
                System.out.println(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //System.out.println("over");
    }
}
