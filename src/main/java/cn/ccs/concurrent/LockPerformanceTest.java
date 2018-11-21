package cn.ccs.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPerformanceTest {

    private static final int NUM = 10000;

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(NUM);
        final Lock lock = new ReentrantLock();

        final ExImpl ex = new ExImpl(latch,lock);
        //ExImpl ex = new ExImpl(lock);
        long lstart = System.currentTimeMillis();

//        for(int num=NUM;num>0;num--){
//            ex.printLock();
//            ex.printSynchronized();
//        }
        try {
            //latch.await();
            long lend = System.currentTimeMillis();
            System.out.println(lend-lstart);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(){
            @Override
            public void run(){
                lock.lock();
                //lock.lock();
                try {
                    Thread.sleep(2000);
                    System.out.println("Thread execute over .........");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }.start();

        try {
            Thread.sleep(1000);
            System.out.println("Main Thread start lock ...");
            lock.lockInterruptibly();
            lock.lock();
            //lock.unlock();
            System.out.println("Main Thread lock over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
class ExImpl {
    private CountDownLatch latch;
    private Lock lock;
    public ExImpl(CountDownLatch latch ){
        this.latch = latch;
    }
    public ExImpl(CountDownLatch latch,Lock lock ){
        this.latch = latch;
        this.lock = lock;
    }
    public ExImpl(Lock lock){
        this.lock = lock;
    }

    public synchronized int printSynchronized() {
        int count = 0;
        for(int i = 0;i<1000000;i++){
            count += i;
        }
        //System.out.println(count);
        latch.countDown();
        return count;
    }

    public int printLock() {
        lock.lock();
        int count = 0;
        for(int i = 0;i<1000000;i++){
            count += i;
        }
        //System.out.println(count);
        lock.unlock();
        latch.countDown();
        return count;
    }
}
