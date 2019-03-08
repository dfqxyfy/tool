package cn.ccs.locksync.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest2 {
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        final Condition conditionA = lock.newCondition();
        final Condition conditionB = lock.newCondition();


        new Thread() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<5;i++) {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName()+"Thread running");
                        //Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName()+"sleeping 2s");
                        //conditionA.signalAll();
                        System.out.println(Thread.currentThread().getName()+"sleeping signalAll");
                        lock.unlock();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<5;i++) {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + "conditionA await");
                        //conditionA.await();
                        System.out.println(Thread.currentThread().getName() + "conditionA await over");
                        System.out.println(Thread.currentThread().getName() + "lock unlock over");
                        lock.unlock();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
