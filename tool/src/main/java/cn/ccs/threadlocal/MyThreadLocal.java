package cn.ccs.threadlocal;

public class MyThreadLocal {

    public static void main(String[] args) throws InterruptedException {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0 ;i<10000;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadLocal<String> local = new ThreadLocal<>();
                    StringBuilder strb = new StringBuilder();
                    for (int j = 0; j < 1024; j++) {
                        strb.append('A' + j % 26);
                    }
                    local.set(strb.toString());
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.setName("thred"+i);
            System.out.println(thread.getName());
            thread.start();
        }

        Thread.sleep(1000000);
    }
}
