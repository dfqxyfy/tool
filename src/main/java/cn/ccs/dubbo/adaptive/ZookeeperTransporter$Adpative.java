package cn.ccs.dubbo.adaptive;

/**
 * Created by ccs on 2017/7/12.
 */

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class ZookeeperTransporter$Adpative implements com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter {
    public com.alibaba.dubbo.remoting.zookeeper.ZookeeperClient connect(com.alibaba.dubbo.common.URL arg0) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        com.alibaba.dubbo.common.URL url = arg0;
        String extName = url.getParameter("client", url.getParameter("transporter", "zkclient"));
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter) name from url(" + url.toString() + ") use keys([client, transporter])");
        com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter extension = (com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter) ExtensionLoader.getExtensionLoader(com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter.class).getExtension(extName);
        return extension.connect(arg0);
    }
}