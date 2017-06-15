package cn.ccs.dubbo.extensionloader;

import com.alibaba.dubbo.common.URL;

/**
 * Created by chaichuanshi on 2017/6/12.
 */
public class OtherExtensionImpl implements MyInterface {

    public OtherExtensionImpl() {
        System.out.println("OtherExtensionImpl");
    }

    @Override
    public String sayHello(URL url, String name, String type) {
        return this.getClass().getName() + "  " + name + "  " + type;
    }

}