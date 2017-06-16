package cn.ccs.dubbo.adaptive;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class MyInterface$Adpative implements cn.ccs.dubbo.extensionloader.MyInterface {
    public java.lang.String sayHello(com.alibaba.dubbo.common.URL arg0, java.lang.String arg1, java.lang.String arg2) {
        if (arg0 == null)
            throw new IllegalArgumentException("url == null");
        com.alibaba.dubbo.common.URL url = arg0;
        String extName = url.getParameter("my.interface", "defaults");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(cn.ccs.dubbo.extensionloader.MyInterface) name from url(" + url.toString() + ") use keys([my.interface])");
        cn.ccs.dubbo.extensionloader.MyInterface extension = (cn.ccs.dubbo.extensionloader.MyInterface) ExtensionLoader.getExtensionLoader(cn.ccs.dubbo.extensionloader.MyInterface.class).getExtension(extName);
        return extension.sayHello(arg0, arg1, arg2);
    }
}