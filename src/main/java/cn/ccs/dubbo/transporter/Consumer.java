package cn.ccs.dubbo.transporter;

import cn.ccs.dubbo.apiconfig.AbService;
import com.alibaba.dubbo.config.*;

/**
 * Created by chaichuanshi on 2017/5/15.
 */
public class Consumer {
    public static void main(String[] args) {

// 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("xxx");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        ReferenceConfig<AbService> reference = new ReferenceConfig<AbService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(AbService.class);
        ConsumerConfig consumer = new ConsumerConfig();

        reference.setConsumer(consumer);
        reference.setClient("ccsTransporter");

        AbService xxxService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        String s = xxxService.find();
        System.out.println("*************** result ************************");
        System.out.println(s);
        System.out.println("*************** result ************************");
    }
}
