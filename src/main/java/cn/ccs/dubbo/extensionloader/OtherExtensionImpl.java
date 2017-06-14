package cn.ccs.dubbo.extensionloader;

/**
 * Created by chaichuanshi on 2017/6/12.
 */
public class OtherExtensionImpl implements MyInterface {

    public OtherExtensionImpl() {
        System.out.println("OtherExtensionImpl");
    }

    @Override
    public String sayHello(String name, String type) {
        return this.getClass().getName() + "  " + name + "  " + type;
    }

}