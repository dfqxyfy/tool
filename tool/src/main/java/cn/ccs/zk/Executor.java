package cn.ccs.zk;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.List;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

public class Executor
        implements Watcher, Runnable, DataMonitor.DataMonitorListener {
    String znode;

    DataMonitor dm;

    ZooKeeper zk;

    String filename;

    String exec[];

    Process child;


    String bathPath = "/ad";

    public Executor(String hostPort, String znode, String filename,
                    String exec[]) throws KeeperException, IOException {
        this.filename = filename;
        this.exec = exec;
        zk = new ZooKeeper(hostPort, 3000, this);
        ;
        //zk.create("/aaa",null,null);
        dm = new DataMonitor(zk, znode, null, this);
        String root = "/ad";
        try {
            //root = zk.create(bathPath, "xxxxxxxxx".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            Stat stat = zk.exists(root,null);
            System.out.println("stat:"+stat);
            System.out.println("root::::::::"+root);
        }catch (Exception e){
            e.printStackTrace();
        }
        new Abcd(zk,root).start();
    }

    static class Abcd extends  Thread{
        String root;
        ZooKeeper zk;
        Abcd(ZooKeeper zk ,String root){
            System.out.println("Abcd:::::::"+root);
            this.zk = zk;
            this.root = root;
        }
        @Override
        public void run(){
            while(true){
                try {
                    sleep(3000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("监控开始。。。。。");
                try {
                    List<String> ls = zk.getChildren(root, true);
                    System.out.println(ls.size());
                    String tempNode = root +"/" + (ls.size() + 1);
                    String node = zk.create(tempNode, "xxxxbc".getBytes(), zk.getACL("/", zk.exists("/", true)), CreateMode.EPHEMERAL);
                    System.out.println(node);
                    List<String> resList = zk.getChildren(root,true);
                    for(int i = 0 ;i<resList.size();i++)
                        System.out.print(resList.get(i)+" ");
                    System.out.println();;
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("监控结束。。。。。");
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
//        if (args.length < 4) {
//            System.err
//                    .println("USAGE: Executor hostPort znode filename program [args ...]");
//            System.exit(2);
//        }
        //String hostPort = "127.0.0.1:2181";//args[0];
        String hostPort = "10.154.156.83:2181";//args[0];
        String znode = "/ad";//args[1];
        String filename = "b";//args[2];
        String exec[] = new String[3];
        //System.arraycopy(args, 3, exec, 0, exec.length);
        try {
            new Executor(hostPort, znode, filename, exec).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void process(WatchedEvent event) {
        dm.process(event);
    }

    public void run() {
        System.out.println(MessageFormat.format("{0}","aa"));
        try {
            synchronized (this) {
                while (!dm.dead) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
        }
    }

    public void closing(int rc) {
        synchronized (this) {
            notifyAll();
        }
    }

    static class StreamWriter extends Thread {
        OutputStream os;

        InputStream is;

        StreamWriter(InputStream is, OutputStream os) {
            this.is = is;
            this.os = os;
            start();
        }

        public void run() {
            byte b[] = new byte[80];
            int rc;
            try {
                while ((rc = is.read(b)) > 0) {
                    os.write(b, 0, rc);
                }
            } catch (IOException e) {
            }

        }
    }

    public void exists(byte[] data) {
        System.out.println(new String(data));
        if (data == null) {
            if (child != null) {
                System.out.println("Killing process");
                child.destroy();
                try {
                    child.waitFor();
                } catch (InterruptedException e) {
                }
            }
            child = null;
        } else {
            if (child != null) {
                System.out.println("Stopping child");
                child.destroy();
                try {
                    child.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                fos.write(data);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("Starting child");
                child = Runtime.getRuntime().exec(exec);
                new StreamWriter(child.getInputStream(), System.out);
                new StreamWriter(child.getErrorStream(), System.err);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}