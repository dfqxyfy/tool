package cn.ccs.concurrent;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chaichuanshi on 2017/7/3.
 */
public class ReentrantLockTest {

    @Test
    public void reentrantLockTest(){
        final ReentrantLock lock = new ReentrantLock(true);


        Array array = null;

        for(int i = 0;i<3;i++) {
            final int bb = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        System.out.println(bb);
                        lock.lock();
//                        if(!lock.tryLock()){
//                            System.out.println("try lock failure");
//                            return;
//                        };
                        Thread.sleep(2000);
                        System.out.println(bb + " over");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.unlock();
                }
            });
            t.setDaemon(false);
            t.start();
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//class ExThread extends Thread
