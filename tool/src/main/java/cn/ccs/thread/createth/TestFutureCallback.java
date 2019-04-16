package cn.ccs.thread.createth;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFutureCallback {

    public static void main(String[] args) {
        FutureCallback futureCallback = new FutureCallback() {
            @Override
            public void onSuccess(Object o) {
                System.out.println(o + " ok");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable + " ok");
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(10);
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
        ListenableFuture<String> futureTask = executorService.submit(new Callable<String>() {
            String str = new String("aaa");
            @Override
            public String call() throws Exception {
                System.out.println(str);
                return str;
            }
        });

        //Futures.addCallback(futureTask, futureCallback);
        //executor.shutdown();
    }


}
