package cn.ccs.threadlocal;

public class MyInheritableThreadLocal {

    public static void main(String[] args) {
        final ThreadLocal<String> inThreadLocal = new InheritableThreadLocal<>();
        final ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("threadLocal mainThread");
        inThreadLocal.set("inThreadLocal mainThread");
        System.out.println(threadLocal.get());
        System.out.println(inThreadLocal.get());
        new Thread(){
            @Override
            public void run(){
                System.out.println(threadLocal.get());
                System.out.println(inThreadLocal.get());
            }
        }.start();
    }
}
