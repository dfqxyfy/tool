package cn.ccs.thread;

public class MyJoin {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sub Thread .... ");
            }
        }
        );
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();


        System.out.println("Main Thread End.............");
    }
}

