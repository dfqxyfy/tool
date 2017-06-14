package cn.ccs.dubbo.extensionloader;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * Created by chaichuanshi on 2017/6/12.
 */
@SPI("defaults")
public interface MyInterface {
    String sayHello(String name, String type);
}