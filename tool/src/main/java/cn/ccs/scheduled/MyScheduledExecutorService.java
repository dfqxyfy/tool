package cn.ccs.scheduled;

import java.util.concurrent.*;

public class MyScheduledExecutorService {
    transient int b;
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        final int i=0;
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(i+" : "+System.currentTimeMillis());
            }
        },1,3,TimeUnit.SECONDS);
        Future f;
        FutureTask ft;
        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
    }
}
