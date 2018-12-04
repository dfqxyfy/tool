package cn.ccs.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chaichuanshi on 2017/4/10.
 */
public class XmlSpringLoad {
    public static void main(String[] args) {
        ApplicationContext atx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        TestBean testBean=(TestBean) atx.getBean("testBean");
        System.out.println(testBean);
    }
}
