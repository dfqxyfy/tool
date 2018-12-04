package cn.ccs.locksync;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.jboss.netty.util.internal.ConcurrentWeakKeyHashMap;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ccs
 */
public class TenThreadsPerSeconds {

    private Timer timer = null;
    private ScheduledExecutorService executorService = null;

    //private final Map<Runnable, Boolean> hashMap = new WeakHashMap<>();

    private static final AtomicInteger activeThreadCount = new AtomicInteger(0);
    private static final AtomicInteger coudlSubmitCount = new AtomicInteger(10);

    public synchronized boolean inovke(final Runnable runnable) {
        initTimer();
        //System.out.println("活跃线程: "+(10-coudlSubmitCount.get()));
        if (coudlSubmitCount.get() <= 0) {
            //System.out.println("丢弃线程："+runnable);
            return false;
        }
        activeThreadCount.addAndGet(1);
        coudlSubmitCount.decrementAndGet();
        new Thread() {
            @Override
            public void run() {
                try {
                    runnable.run();
                    super.run();
                } catch (Exception e){
                    e.printStackTrace();
                } finally{
                    activeThreadCount.decrementAndGet();
                }
            }
        }.start();

        return true;
    }

    private synchronized void initTimer() {

        if(executorService == null) {
            //org.apache.commons.lang3.concurrent.BasicThreadFactory
            executorService = new ScheduledThreadPoolExecutor(1,
                    new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
            executorService.scheduleAtFixedRate(new MyTask(), 0, 10, TimeUnit.SECONDS);
        }
//        if (timer == null) {
//            timer = new Timer();
//            timer.schedule(new MyTask(), new Date(), 1000);
//        }
    }

    class MyTask extends TimerTask implements Runnable{

        @Override
        public void run() {
            System.out.println("开始检测活跃线程数："+ activeThreadCount.get());
            int count = 10 - activeThreadCount.get();
            coudlSubmitCount.set(count);
            System.out.println("设置完成检测："+ coudlSubmitCount.get());
        }
    }

    public static void main(String[] args) {

        TenThreadsPerSeconds mutithread = new TenThreadsPerSeconds();
        for(int i = 0;i<100000;i++){
            //System.out.println("还可继续执行线程数："+coudlSubmitCount.get());
            boolean inovke = mutithread.inovke(new MyThread(coudlSubmitCount));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class MyThread extends Thread {

        AtomicInteger coudlAddCount ;

        private static AtomicInteger threadNum = new AtomicInteger(0);
        public MyThread(AtomicInteger coudlAddCount ){
            this.coudlAddCount = coudlAddCount;
        }

        @Override
        public void run() {
            try {
                //Thread.sleep(new Random().nextInt(1000));
                //Thread.sleep(50+new Random().nextInt(2500));
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //LocalDate now = LocalDate.now();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            System.out.println(format+"\t"+coudlAddCount.get()+"\t"+ Thread.currentThread().getName() + "\t执行完毕\t"+threadNum.addAndGet(1)+" 次数");
        }
    }
}
