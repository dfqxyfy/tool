package cn.ccs.dubbo.extensionloader;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * Created by chaichuanshi on 2017/6/12.
 */
@SPI("defaults")
public interface MyInterface {
    @Adaptive
    String sayHello(URL url, String name, String type);
}