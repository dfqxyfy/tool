package cn.ccs.locksync.synchtest;

public class SynchObject {

     static synchronized public void methodA() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a");
    }

    static synchronized public void methodB() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b");
        methodA();
    }

    public static void main(String[] args) {
        SynchObject object = new SynchObject();
        SynchObject.methodB();
        ThreadA a = new ThreadA(object);
        ThreadB b = new ThreadB(object);
        a.start();
        b.start();
    }
}

class ThreadA extends Thread {

    private SynchObject object;
    public ThreadA(SynchObject object){
        this.object=object;
    }
    @Override
    public void run() {
        super.run();
        //object.methodA();
        SynchObject.methodA();
    }
}

class ThreadB extends Thread {
    private SynchObject object;
    public ThreadB(SynchObject object){
        this.object=object;
    }
    @Override
    public void run() {
        super.run();
        //object.methodB();
        SynchObject.methodB();
    }
}
