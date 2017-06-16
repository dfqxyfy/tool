package cn.ccs.dubbo.extensionloader;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * Created by chaichuanshi on 2017/6/12.
 */
//@Adaptive
public class MyAdaptiveExtension implements MyInterface {
    public MyAdaptiveExtension(){
        System.out.println(this.getClass().getSimpleName());
    }

    @SuppressWarnings("rawtypes")
    @Override
    public String sayHello(URL url, String name, String type) {
        ExtensionLoader extensionLoader = ExtensionLoader.getExtensionLoader(MyInterface.class);
        //ExtensionLoader extensionLoader = ExtensionLoader.getExtensionLoader();
        //extensionLoader.get
        MyInterface extension = (MyInterface) extensionLoader.getDefaultExtension();
        if (ExtensionType.defaults.equals(type)) {
            extension = (MyInterface) extensionLoader.getExtension("defaults");
        }
        if (ExtensionType.other.equals(type)) {
            extension = (MyInterface) extensionLoader.getExtension("other");
        }
        return extension.sayHello(url, name, type);
    }
}