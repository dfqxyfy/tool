package cn.ccs.cas;

public class LockTest {
    public static void main(String[] args) {
        final SpinLock lock = new SpinLock();

        for(int i = 0;i<10;i++){
            final int count = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(count);
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
}
