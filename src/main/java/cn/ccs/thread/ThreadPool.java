package cn.ccs.thread;

import java.util.concurrent.*;

public class ThreadPool {

    private static  final  ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//    static {
//        try {
//            fixedThreadPool = Executors.newFixedThreadPool(3, 3, 0L, TimeUnit.MILLISECONDS,
//                    new LinkedBlockingQueue<Runnable>(), new RejectedExecutionHandler() {
//                        @Override
//                        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                        }
//                    });
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            final int a = i;
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(a);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
