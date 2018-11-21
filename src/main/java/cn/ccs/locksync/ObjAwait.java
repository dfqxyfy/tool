package cn.ccs.locksync;

public class ObjAwait {
    public static void main(String[] args) {
        final Obj obj = new Obj();
        final String str2 = new String("aa");
        final Thread t = Thread.currentThread();
        new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(2000);
                    System.out.println("notify");
                    synchronized (str2) {
                        str2.notify();
                        str2.notify();
                        str2.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        obj.sync(str2);
        System.out.println("obj wait over ...");
    }
}
class Obj{
    public void sync(String str2){
        try {
            synchronized (str2) {
                str2.wait();
            }
            System.out.println("wait over.......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
