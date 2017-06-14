package cn.ccs.dubbo.test;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * Created by chaichuanshi on 2017/5/27.
 */
public class ExtensionLoaderTest {

    @Test
    public void testLoader(){
        ExtensionLoader.getExtensionLoader(IService.class);
    }
}
