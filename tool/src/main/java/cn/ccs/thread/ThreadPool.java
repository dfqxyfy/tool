package cn.ccs.thread;

import org.jetbrains.annotations.NotNull;

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

    private static ExecutorService threadPoolExecutor = new ThreadPoolExecutor(0, 3,60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    private static ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(2, 5, 60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(3) ,
            new MyFactory(), new MyRejectHandler());

    public static void main(String[] args) {
        for(int i = 0;i<12;i++){
            final int a = i;
            try {


                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPoolExecutor2.submit(new Runnable() {
                @Override
                public void run() {

                    System.out.println("core:"+threadPoolExecutor2.getCorePoolSize()+"\tactive:"+threadPoolExecutor2.getActiveCount()+"\tqueue:"+
                            threadPoolExecutor2.getQueue().size()
                            +"\tmaxSize:"+threadPoolExecutor2.getMaximumPoolSize()
                    );

                    System.out.println("submit:"+a);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } );

        }

        try {
            Thread.sleep(2000);
            for(int i=0;i<100;i++){
                System.out.println("Det  core:"+threadPoolExecutor2.getCorePoolSize()+"\tactive:"+threadPoolExecutor2.getActiveCount()+"\tqueue:"+
                        threadPoolExecutor2.getQueue().size()
                        +"\tmaxSize:"+threadPoolExecutor2.getMaximumPoolSize()
                );
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyFactory implements ThreadFactory{

    static int num=0;

    @Override
    public Thread newThread(@NotNull Runnable r) {
        Thread thread = new Thread(r);
//        {
//            @Override
//            public void run(){
//                try {
//                    //Thread.sleep(1000);
//                    num++;
//                    this.setName(num+"");
//                    System.out.println("创建线程数 and exec ："+num);
//                    Thread.sleep(100000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
        return thread;
    }
}
class MyRejectHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("拒绝："+r.getClass()+" "+executor.getClass());
    }
}