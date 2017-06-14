package cn.ccs.zk.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * Created by chaichuanshi on 2016/12/13.
 */
public class ZkLockTest {


    public CuratorFramework curatorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        //String zookeeperConnectionString = "127.0.0.1:2181";
        String zookeeperConnectionString = "10.11.147.37:2181";
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(zookeeperConnectionString, 50000, 30000,
                retryPolicy);
        return curatorFramework;
    }



    public void testLock() {
        String pathEpisode = "/ccs/dev/test/";
        String leSportsId = "111111";

        CuratorFramework client = curatorFramework();
        client.start();


        String path = "/temp/bbb";
        try {
            //client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path,"init".getBytes());
            //Stat stat = new Stat();
            //client.getData().storingStatIn(stat).forPath(path);
            //client.delete().deletingChildrenIfNeeded().forPath(path);

            //client.getZookeeperClient().getZooKeeper().create(path,null,null,CreateMode.EPHEMERAL);
            //client.getZookeeperClient().getZooKeeper().create(path, "xxxxxxxxx".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            //Stat stat = client.getZookeeperClient().getZooKeeper().exists(path,null);
            //client.getZookeeperClient().getZooKeeper().delete(path,stat.getVersion());


            //new Reaper(client).removePath(path);


            //new ChidReaper();
        } catch (Exception e) {
            e.printStackTrace();
        }

        InterProcessMutex lock = new InterProcessMutex(client, path);
        try {
            boolean b = lock.acquire(5, TimeUnit.MINUTES);
            System.out.println("locking acquire" + b);
        } catch (Exception e) {
            System.out.println("............................");
            e.printStackTrace();
            System.out.println("............................");
        }finally {
            try {
                if(lock != null) {
                    System.out.println("lock release....");
                    lock.release();
                    //Thread.sleep(10000000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ZkLockTest zkTest = new ZkLockTest();
        zkTest.testLock();
    }
}
