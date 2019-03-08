package cn.ccs.locksync.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String[] args) {
        Obj obj = new Obj();
        final Condition condition = obj.conditon;

        ExThread exThread = new ExThread(condition);
        exThread.start();

        //condition.signal();
    }

}
class Obj{
    public Lock lock = new ReentrantLock();
    public Condition conditon = lock.newCondition();
}
class ExThread extends Thread{
    Condition condition;
    public ExThread(Condition condition){
        this.condition = condition;
    }
    @Override
    public void run(){
        System.out.println("condition start");
        try {
            Thread.sleep(1000);
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("condition over");
    }
}
