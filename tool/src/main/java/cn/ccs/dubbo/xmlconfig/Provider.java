package cn.ccs.dubbo.xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chaichuanshi on 2017/5/16.
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext-provider.xml"});
        context.start();

        System.in.read(); // 按任意键退出
    }

}
