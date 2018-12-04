package cn.ccs.memcache;//package cn.ccs.memcache;
//
//import com.danga.MemCached.MemCachedClient;
//import com.danga.MemCached.SockIOPool;
//
//import java.io.Serializable;
//import java.util.Date;
//
///**
// * Created by chaichuanshi on 2016/12/8.
// */
//public class MemcacheManagerForGwhalin {
//    // 构建缓存客户端
//    private static MemCachedClient cachedClient;
//    // 单例模式实现客户端管理类
//    private static MemcacheManagerForGwhalin INSTANCE = new MemcacheManagerForGwhalin();
//    private MemcacheManagerForGwhalin() {
//        cachedClient = new MemCachedClient();
//        //获取连接池实例
//        SockIOPool pool = SockIOPool.getInstance();
//        //设置缓存服务器地址，可以设置多个实现分布式缓存
//        pool.setServers(new String[]{"127.0.0.1:11211"});
//        //设置初始连接5
//        pool.setInitConn(5);
//        //设置最小连接5
//        pool.setMinConn(5);
//        //设置最大连接250
//        pool.setMaxConn(250);
//        //设置每个连接最大空闲时间3个小时
//        pool.setMaxIdle(1000 * 60 * 60 * 3);
//        pool.setMaintSleep(30);
//        pool.setNagle(false);
//        pool.setSocketTO(3000);
//        pool.setSocketConnectTO(0);
//        pool.initialize();
//    }
//    /**
//     *
//     *
//     * 获取缓存管理器唯一实例
//     * @return
//     */
//    public static MemcacheManagerForGwhalin getInstance() {
//        return INSTANCE;
//    }
//    public void add(String key, Object value) {
//        cachedClient.set(key, value);
//    }
//    public void add(String key, Object value, int milliseconds) {
//        cachedClient.set(key, value, milliseconds);
//    }
//    public void remove(String key) {
//        cachedClient.delete(key);
//    }
//    public void remove(String key, int milliseconds) {
//        cachedClient.delete(key, milliseconds, new Date());
//    }
//    public void update(String key, Object value, int milliseconds) {
//        cachedClient.replace(key, value, milliseconds);
//    }
//    public void update(String key, Object value) {
//        cachedClient.replace(key, value);
//    }
//    public Object get(String key) {
//        return cachedClient.get(key);
//    }
//    public static void main(String args[]){
//        MemcacheManagerForGwhalin memcache = MemcacheManagerForGwhalin.getInstance();
//        memcache.add("4", new User("1 ","2"));
//        memcache.add("4", new User("11","22"));
//        System.out.println(memcache.get("4"));
//        //cachedClient.delete("3");
//        for(int i = 0 ;i<1;i++){
//            new ExThread(cachedClient,i+"").start();
//        }
//        System.out.println("over");
//    }
//
//}
//class ExThread extends Thread{
//    private MemCachedClient cachedClient;
//    private String name;
//
//    public ExThread( MemCachedClient cachedClient, String name) {
//        this.cachedClient = cachedClient;
//        this.name = name;
//    }
//
//    @Override
//    public void run(){
//        Integer time = 3000;
//        System.out.println("run.......");
//        if(cachedClient.add("3","5",time)){
//            try{
//                System.out.println("sleeping..."+name);
//                Thread.sleep(time-1000);
//            }catch (Exception e){
//            }finally {
//                cachedClient.delete("3");
//                System.out.println("sleeping...over"+name);
//            }
//        }else{
//            try {
//                System.out.println("try lock ..."+name);
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            run();
//        }
//    }
//}
//
//
//class User implements Serializable { //必须将对象序列化才能保存
//    public String userName;
//    public String password;
//
//    public User(String userName,String password){
//        this.userName = userName;
//        this.password = password;
//    }
//
//    @Override
//    public String toString(){
//        return userName+"-"+password;
//    }
//}
