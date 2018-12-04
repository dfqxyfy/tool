package cn.ccs.locksync.reentrantlock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task {
    
    private final Lock lock = new ReentrantLock();
    
    private final Condition addCondition = lock.newCondition();
    private final Condition subCondition = lock.newCondition();
    private static int num = 0;
    private List<String> lists = new LinkedList<String>();
    
    public void add() {
        lock.lock();
        try {
            Thread.sleep(500);
            //当集合已满,则"添加"线程等待
            //while(lists.size() == 10) {
            if(lists.size() == 10) {
                addCondition.await();
            }
            
            num++;
            lists.add("add Banana" + num);
            System.out.println("The Lists Size is " + lists.size());
            System.out.println("The Current Thread is " + Thread.currentThread().getName());
            this.subCondition.signal();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {//释放锁
            lock.unlock();
        }
    }
    
    
    public void sub() {
        lock.lock();
        
        try {
            Thread.sleep(500);
            //当集合为空时,"减少"线程等待
            //while(lists.size() == 0) {
            if(lists.size() == 0) {
                subCondition.await();
            }
            
            String str = lists.get(0);
            lists.remove(0);
            System.out.println("The Token Banana is [" + str + "]");
            System.out.println("The Current Thread is " + Thread.currentThread().getName());
            num--;
            addCondition.signal();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        for(int i = 0;i<12;i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new AddThread(task)).start();
        }
        for(int i = 0;i<20;i++) {
            new Thread(new SubThread(task)).start();
        }
    }
    
}
class AddThread implements Runnable {

    private Task task;
    public AddThread(Task task) {
        this.task = task;
    }
    @Override
    public void run() {
        task.add();
    }

}
class SubThread implements Runnable {

    private Task task;
    public SubThread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.sub();
    }

}