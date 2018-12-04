package cn.ccs.spring.childparent;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Map;

/**
 * Created by chaichuanshi on 2016/10/27.
 */

@Configurable
@ComponentScan(basePackageClasses = {ChildContext.class})
public class ChildContext {

//
//    public void init() {
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ChildContext.class);
//        ChildContext sc = annotationConfigApplicationContext.getBean("springConfig",ChildContext.class);
//    }

    public void aaa(String aa,String bb){
        System.out.println("aaa,"+aa);
    }

    @Bean(name="childBean")
    public TestBean getTestBean(){
        TestBean testBean = new TestBean(ChildContext.class);
        return testBean;
    }
}
