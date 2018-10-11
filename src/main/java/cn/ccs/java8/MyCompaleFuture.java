package cn.ccs.java8;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MyCompaleFuture {

    @Test
    public void testComplete(){
        CompletableFuture<MyFunIn> future =

//                CompletableFuture.completedFuture(new MyFunIn() {
//            @Override
//            public void aaTest() {
//                System.out.println("aaTest success");
//            }
//        });

                new CompletableFuture<>();
        future.thenRun(new Runnable() {
            @Override
            public void run() {
                System.out.println("futurn then run");
            }
        });

        try {
            MyFunIn myFunIn = future.get();
            //myFunIn.aaTest();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

@FunctionalInterface
interface MyFunIn{
    void aaTest();
}