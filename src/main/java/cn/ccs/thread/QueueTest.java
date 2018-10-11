package cn.ccs.thread;

import java.util.concurrent.SynchronousQueue;

public class QueueTest {
    public static void main(String[] args) {
        final SynchronousQueue<String> queue = new SynchronousQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                    queue.put("aaaa");
                    System.out.println("put over......... aaaa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    queue.put("aaaa2");
                    System.out.println("put over......... aaaa2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                    String poll = queue.poll();
                    System.out.println("poll over......... " + poll);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
// 遍历线程组树，获取根线程组
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
// 激活的线程数加倍
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];
// 获取根线程组的所有线程
        int actualSize = topGroup.enumerate(slackList);
// copy into a list that is the exact size
        Thread[] list = new Thread[actualSize];
        System.arraycopy(slackList, 0, list, 0, actualSize);
        System.out.println("Thread list size == " + list.length);
        for (Thread thread : list) {
            System.out.println(thread.getName());


            ThreadLocal<String> tl;
        }

    }

}
