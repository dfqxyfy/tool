package cn.ccs.jvm;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public class MyWeakReference {

    public static void main(String[] args) {

        /**
         * 确定弱引用会自动回收
         */
        WeakHashMap<Ab,Integer> weakHashMap = new WeakHashMap();
        HashMap<Ab,Integer> hashMap = new HashMap();

        for(int i =0;i<1000;i++){
            weakHashMap.put(new Ab(),5);
            hashMap.put(new Ab(),5);
        }

        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(weakHashMap.size());
        System.out.println(hashMap.size());

        /**
         * 弱引用 WeakHashMap key 置为空，系统gc后，weakHashMap2的大小变为0
         */
        WeakHashMap<Ab,Integer> weakHashMap2 = new WeakHashMap();
        Ab ab = new Ab("aaa");
        weakHashMap2.put(ab,33);

        ab = null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(weakHashMap2.size());

        /**
         * 虚引用
         */
        Ab temp = new Ab("temp");
        WeakReference<Ab> weakReference = new WeakReference<>(temp);

        int i = 0;
        while(true){

            i++;
            if(weakReference.get() == null){
                System.out.println("null");
                break;
            }else{
                i++;
                //System.out.println("weakReference is not null");
            };


        }
        System.out.println(temp);
    }
}
