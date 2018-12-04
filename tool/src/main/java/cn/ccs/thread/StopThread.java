package cn.ccs.thread;

/**
 * Created by ccs on 2017/7/16.
 */
public class StopThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run(){
                while(true){
                    Object o = new Object();
                }
            }
        };

        int i ;
        //System.out.println(i);
        t1.start();
        t1.interrupt();
        //t1.stop();
        System.out.println("over");
    }
}

