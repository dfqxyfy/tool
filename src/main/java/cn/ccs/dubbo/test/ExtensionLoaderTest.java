package cn.ccs.dubbo.test;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.Date;

/**
 * Created by chaichuanshi on 2017/5/27.
 */
public class ExtensionLoaderTest {

    @Test
    public void testLoader() {
        ExtensionLoader.getExtensionLoader(IService.class);
    }

    @Test
    public void dat() {
        long l = System.currentTimeMillis();
        System.out.println(l);
        System.out.println(new Date(l));
        System.out.println(new Date(l/1000));
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
    }
}
