package cn.ccs.locksync.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        final Data data = new Data();

        for (int i = 0; i < 5; i++) {
            new Thread("Thread-read-"+i){
                @Override
                public void run(){
                    System.out.println(data.getStr());
                }
            }.start();
        }
        for(int i = 0;i<5;i++){
            final int num = i;
            new Thread("Thread-write-"+num){
                @Override
                public void run(){
                    //System.out.println("Thread "+this.getName()+" -- ");
                    data.setStr("**********" + num);
                }
            }.start();

        }

    }
}

class Data {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(true);
    private final Lock rlock = rwl.readLock();
    private final Lock wlock = rwl.writeLock();


    private String str = "5555";

    public String getStr() {
        try {
            rlock.lock();
            System.out.println(Thread.currentThread().getName()+"\t"+"get locked\t"+str);
            Thread.sleep(1000);
            return str;
        } catch (Exception e) {
            return str;
        } finally {
            rlock.unlock();
            System.out.println(Thread.currentThread().getName()+"\t"+"get unlocked\t"+str);
        }
    }

    public void setStr(String str) {
        try {
            wlock.lock();
            //rlock.lock();
            System.out.println(Thread.currentThread().getName()+"\t"+"write locked\t"+str);
            Thread.sleep(1000);
            this.str = str;
        } catch (Exception e) {
        } finally {
            wlock.unlock();
            System.out.println(Thread.currentThread().getName()+"\t"+"write unlocked\t"+str);
        }
    }
}
