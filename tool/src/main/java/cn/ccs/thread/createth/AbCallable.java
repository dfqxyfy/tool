package cn.ccs.thread.createth;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class AbCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("call 完成");
        return "sout call 返回结果";
    }

    public static void main(String[] args) {

        AbCallable callable = new AbCallable();


        FutureTask ft = new FutureTask(callable);
        Thread thread = new Thread(ft);
        thread.start();
        try {
            Object o = ft.get();
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("执行结束：over");
    }
}
