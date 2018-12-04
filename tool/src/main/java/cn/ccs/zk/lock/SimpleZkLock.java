package cn.ccs.zk.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

public class SimpleZkLock {

    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        String zookeeperConnectionString = "127.0.0.1:2181";
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(zookeeperConnectionString, 50000, 30000,
                retryPolicy);
        curatorFramework.start();
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, "/a/c");
        boolean b = lock.acquire(10, TimeUnit.SECONDS);
        System.out.println("locking acquire... " + b);
        Thread.sleep(100000);
        System.out.println("over");
        lock.release();
    }

}
