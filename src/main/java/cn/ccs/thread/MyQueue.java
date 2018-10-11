package cn.ccs.thread;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class MyQueue {
    public static void main(String[] args) {
        final Queue<String> queue = new SynchronousQueue();
        //final Queue<String> queue  = new LinkedBlockingQueue<>();
        for(int i=0;i<10;i++) {
            final int count = i;
            Thread aaaa = new Thread() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(count*100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    boolean aaaa = queue.add("aaaa"+count);
                    String poll = queue.poll();
                    System.out.println(poll);
                }
            };
            aaaa.start();
        }
    }
}
