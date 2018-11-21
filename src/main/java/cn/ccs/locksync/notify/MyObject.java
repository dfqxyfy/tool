package cn.ccs.locksync.notify;

public class MyObject {

    synchronized public void methodA() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a");
    }

    synchronized public void methodB() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b");
    }

    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        ThreadB b = new ThreadB(object);
        b.start();
        a.start();
    }
}

class ThreadA extends Thread {

    private MyObject object;
    public ThreadA(MyObject object){
        this.object=object;
    }
    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}

class ThreadB extends Thread {
    private MyObject object;
    public ThreadB(MyObject object){
        this.object=object;
    }
    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}
