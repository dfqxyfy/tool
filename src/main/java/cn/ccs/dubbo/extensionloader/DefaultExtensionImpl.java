package cn.ccs.dubbo.extensionloader;

/**
 * Created by chaichuanshi on 2017/6/12.
 */
public class DefaultExtensionImpl implements MyInterface {

    public DefaultExtensionImpl(){
        System.out.println("DefaultExtensionImpl");
    }

    @Override
    public String sayHello(String name, String type) {
        return this.getClass().getName() + "  " + name + "  " + type;
    }

}