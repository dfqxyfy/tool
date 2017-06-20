package cn.ccs.dubbo.extensionloader;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.compiler.support.AdaptiveCompiler;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by chaichuanshi on 2017/6/12.
 */
public class ExtensionTest {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        AdaptiveCompiler.setDefaultCompiler("jdk");
        ExtensionLoader extensionLoader = ExtensionLoader.getExtensionLoader(MyInterface.class);
        MyInterface myFirstExtension = (MyInterface) extensionLoader.getAdaptiveExtension();
        URL url = new URL("http","127.0.0.1",8080, new java.util.HashMap<String,String>(){
            {
                put("my.interface","other");
            }
        });
        System.out.println(myFirstExtension.sayHello(url,"xxx", ExtensionType.defaults));
        System.out.println(myFirstExtension.sayHello(url, "xxx", ExtensionType.other));
    }
}