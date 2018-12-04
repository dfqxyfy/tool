package cn.ccs.zk.temp;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaichuanshi on 2016/12/9.
 */
public class MonitorZk {

    private static String[] arrs = {
            "com.lecloud.bes.service.GoodsAuthService", "com.lecloud.bes.service.CustomerService",
    };
    public static ZooKeeper zk;

    static {
        try {

            zk = new ZooKeeper("10.154.156.83:2181", 3000, new MyWatcher(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        //List<String> list = zk.getChildren("/dubbo", new MyWatcher() );\
        List<String> list = zk.getChildren("/dubbo/com.lecloud.bes.service.GoodsAuthService/providers", new MyWatcher());
        System.out.println("......................");
        for (String s : list) {
            Map<String, String> resMap = new HashMap<>();
            System.out.println(URLDecoder.decode(s, "utf-8"));
            String temp = URLDecoder.decode(s, "utf-8");
            if (!temp.contains("?"))
                continue;
            String[] allAttrs = temp.split("\\?")[1].split("&");
            for (String attr : allAttrs) {
                resMap.put(attr.split("=")[0], attr.split("=")[1]);
            }
            System.out.println("........resMap..............");
            System.out.println(resMap);
            System.out.println("........resMap..............");
        }
        handler("/dubbo/com.lecloud.bes.service.GoodsAuthService/providers");

        System.out.println("......................");

        Thread.sleep(1000000);

    }

    public static void handler(String path) throws KeeperException, InterruptedException {
        zk.getChildren(path, new MyWatcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("event............." + event.getWrapper().getType());
                System.out.println(event.getType() + "//" + event.getPath());
                try {
                    switch (event.getType()) {
                        case NodeChildrenChanged:
                            handler(event.getPath());
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

class MyWatcher implements Watcher {
    @Override
    public void process(WatchedEvent event) {
        System.out.println(event.getType() + "//" + event.getPath());
    }
}
