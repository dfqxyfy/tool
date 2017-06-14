package cn.ccs.dubbo.extensionloader;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * Created by chaichuanshi on 2017/6/12.
 */
public class ExtensionTest {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ExtensionLoader extensionLoader = ExtensionLoader.getExtensionLoader(MyInterface.class);
        MyInterface myFirstExtension = (MyInterface) extensionLoader.getAdaptiveExtension();
        System.out.println(myFirstExtension.sayHello("xxx", ExtensionType.defaults));
        System.out.println(myFirstExtension.sayHello("xxx", ExtensionType.other));
    }
}