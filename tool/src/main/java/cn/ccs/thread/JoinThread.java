package cn.ccs.thread;

public class JoinThread {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run(){
                for(int i=0;i<5;i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread execute ..");
                }
                System.out.println("thread execute over..");
            }
        };
        try {
            t.start();
            t.join(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("adfsfsaf");
    }
}
