package cn.ccs.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SomeCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("abcd");
        return "aaaa";
    }

    public static void main(String[] args) {
        Callable<String> oneCallable = new SomeCallable();
        //由Callable<Integer>创建一个FutureTask<Integer>对象：
        FutureTask<String> oneTask = new FutureTask<String>(oneCallable);
        //注释：FutureTask<Integer>是一个包装器，它通过接受Callable<Integer>来创建，它同时实现了Future和Runnable接口。
        //由FutureTask<Integer>创建一个Thread对象：
        Thread oneThread = new Thread(oneTask){
            @Override
            public void run(){
                System.out.println("callable");
                super.run();
            }
        };
        oneThread.start();
        try {
            System.out.println(oneTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
