package cn.ccs.dubbo.adaptive;

/**
 * Created by ccs on 2017/6/16.
 */
import com.alibaba.dubbo.common.extension.ExtensionLoader;
public class MyInterface$Adpative implements cn.ccs.dubbo.extensionloader.MyInterface {
    public java.lang.String sayHello(com.alibaba.dubbo.common.URL arg0, java.lang.String arg1, java.lang.String arg2) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        com.alibaba.dubbo.common.URL url = arg0;
        String extName = url.getParameter("my.interface", "defaults");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(cn.ccs.dubbo.extensionloader.MyInterface) name from url(" + url.toString() + ") use keys([my.interface])");
        cn.ccs.dubbo.extensionloader.MyInterface extension = (cn.ccs.dubbo.extensionloader.MyInterface) ExtensionLoader.getExtensionLoader(cn.ccs.dubbo.extensionloader.MyInterface.class).getExtension(extName);
        return extension.sayHello(arg0, arg1, arg2);
    }

    public java.lang.String sayNo(java.lang.String arg0) {
        throw new UnsupportedOperationException("method public abstract java.lang.String cn.ccs.dubbo.extensionloader.MyInterface.sayNo(java.lang.String) of interface cn.ccs.dubbo.extensionloader.MyInterface is not adaptive method!");
    }
}