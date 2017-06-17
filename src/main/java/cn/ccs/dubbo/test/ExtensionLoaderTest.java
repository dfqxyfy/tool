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

    @Test
    public void getClassSimpleName(){
        System.out.println(MyInterface.class.getSimpleName());
        System.out.println(MyInterface.class.getCanonicalName());

    }
    @Test
    public void testStringFormat(){
        String s = String.format("\n%s extension = (%<s)%<s.getExtensionLoader(%s.class).getExtension(extName);","aa","bb","cc");
        s = String.format ("%(f", -99.99);
        System.out.println(s);
    }
}
