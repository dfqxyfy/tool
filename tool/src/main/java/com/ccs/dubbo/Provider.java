package com.ccs.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by ccs on 2017/5/12.
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext-provider.xml"});
        context.start();

        System.out.println(" app run ");

        System.in.read(); // 按任意键退出
    }
}
