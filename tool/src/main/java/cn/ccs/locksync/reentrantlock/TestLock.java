package cn.ccs.locksync.reentrantlock;

import cn.ccs.locksync.reentrantlock.AddThread;
import cn.ccs.locksync.reentrantlock.SubThread;
import cn.ccs.locksync.reentrantlock.Task;

public class TestLock {
    
    public static void main(String[] args) {
        Task task = new Task();
        
        Thread t1=new Thread(new AddThread(task));
        Thread t3=new Thread(new AddThread(task));
        Thread t7=new Thread(new AddThread(task));
        Thread t8=new Thread(new AddThread(task));
        Thread t2 = new Thread(new SubThread(task));
        Thread t4 = new Thread(new SubThread(task));
        Thread t5 = new Thread(new SubThread(task));
        Thread t6 = new Thread(new SubThread(task));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }

}