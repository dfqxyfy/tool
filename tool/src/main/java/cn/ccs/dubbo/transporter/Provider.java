package cn.ccs.dubbo.transporter;

import cn.ccs.dubbo.apiconfig.AbService;
import cn.ccs.dubbo.apiconfig.AbServiceImpl;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

/**
 * Created by chaichuanshi on 2017/5/15.
 */
public class Provider {
    public static void main(String[] args) {
        AbService xxxService = new AbServiceImpl();

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("xxx");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(12345);
        protocol.setTransporter("ccsTransporter");

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
        // 服务提供者暴露服务配置
        ServiceConfig<AbService> service = new ServiceConfig<AbService>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(AbService.class);
        service.setRef(xxxService);

        // 暴露及注册服务
        service.export();

        System.out.println("over............");
        try{
            Thread.sleep(10000000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
