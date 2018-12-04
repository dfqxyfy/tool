package cn.ccs.thread;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestD {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());


        System.out.println(new TestD());

        String regex = "([\\w\\d]*)(\\.[\\w\\d]*)+@[\\w\\d]+";


        Pattern compile = Pattern.compile(regex);
        String str = new TestD().toString()+".";
        str = "cn.ccs.thre?ad.TestD@31221b.?e2";
        Matcher matcher = compile.matcher(str);
        boolean b = matcher.find();
        String s = str.replaceAll(regex, "*****");


        System.out.println(str);
        System.out.println(s);
        System.out.println(matcher.group());;
        System.out.println(b);

        if(true){
            return;
        }

        new Thread(new Thread1()).start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(new Thread2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

        //Thread.sleep(10000);
    }

    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            synchronized (TestD.class) {
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting...");
                try {
                    //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                    TestD.class.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized (TestD.class) {
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                TestD.class.notify();
            }
                //==================
                //区别
                //如果我们把代码：TestD.class.notify();给注释掉，即TestD.class调用了wait()方法，但是没有调用notify()
                //方法，则线程永远处于挂起状态。
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");

        }
    }
}