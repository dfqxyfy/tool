package cn.ccs.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyCyclicBarrier {
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for(int i=0;i<4;i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        cyclicBarrier.await();
                        System.out.println(Thread.currentThread().getName()+"\t await");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread ");
                }
            }.start();
        }
        try {
            Thread.sleep(1000);
            //cyclicBarrier.reset();
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }
}
