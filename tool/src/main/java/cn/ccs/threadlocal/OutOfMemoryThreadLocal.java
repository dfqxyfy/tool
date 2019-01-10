package cn.ccs.threadlocal;

import java.util.WeakHashMap;

public class OutOfMemoryThreadLocal {
    public static void main(String[] args) throws Exception {
        final ThreadLocal<String> local = new ThreadLocal<>();


        Thread.sleep(10000);

        final WeakHashMap<Thread,String> weakHashMap = new WeakHashMap<>();
        for(int i = 0 ;;i++){
            final int count = i;
            Thread thread = new Thread(new Runnable() {
                //final ThreadLocal<String> local = new ThreadLocal<>();
                @Override
                public void run() {
                    StringBuilder strb = new StringBuilder();
                    for (int j = 0; j < 1024*1024; j++) {
                        strb.append('A' + j % 26);
                    }
                    if(count%1==0){
                        System.out.println("count :"+weakHashMap.size());
                    }
                    local.set(strb.toString());
                    //weakHashMap.put(Thread.currentThread(),strb.toString());
                }
            });
            thread.setName("thread"+i);
            //System.out.println(thread.getName());
            thread.start();
        }

        //Thread.sleep(1000000);
    }
}
