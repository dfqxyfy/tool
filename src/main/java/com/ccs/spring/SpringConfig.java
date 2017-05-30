package com.ccs.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ccs on 2017/5/2.
 */
@Configuration
@ComponentScan("com.ccs.spring")
public class SpringConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestBean bean = applicationContext.getBean(TestBean.class);
        System.out.println(bean.getName());
    }

    @Bean
    public TestBean getBean(){
        TestBean testBean = new TestBean();
        testBean.setName("aaa");
        return testBean;
    }
}
