package cn.ccs.concurrent;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLatch {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        new MyThread(countDownLatch).start();
        try {
            Thread.sleep(3000);
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("overing.....");

    }
    static class MyThread extends Thread{
        CountDownLatch countDownLatch;
        MyThread(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run(){
            System.out.println("Thread.sleep");
            countDownLatch.countDown();
            System.out.println("Thread.sleep Over");
        }
    }
}
