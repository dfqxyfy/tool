package com.ccs.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ccs on 2017/5/12.
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext-consumer.xml" });
        context.start();
        DubboService dubboService = (DubboService) context.getBean("dubboService"); // 获取bean
        // service
        // invocation
        // proxy
        String message = "";
        try {
            message = dubboService.sayHello("2016-10-20");
            System.out.println(" the message from server is:" + message);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
