package cn.ccs.spring.lazy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Map;

/**
 * Created by chaichuanshi on 2016/10/27.
 */

@Configurable
@EnableAspectJAutoProxy
@ComponentScan(value = {"cn.ccs.sping.lazy"},lazyInit = true)
public class SpringLazyConfig {

    private static Logger logger = LoggerFactory.getLogger(SpringLazyConfig.class);

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringLazyConfig.class);
        //annotationConfigApplicationContext.register(SpringLazyConfig.class);
        //annotationConfigApplicationContext.scan("cn.ccs.spring.lazy");
        //annotationConfigApplicationContext
        //annotationConfigApplicationContext.refresh();
        Map<String,LazyBeans> map = annotationConfigApplicationContext.getBeansOfType(LazyBeans.class);

        System.out.println("*****************");
        map.keySet().forEach(s -> {
            System.out.println(s);
        });
        System.out.println("*****************");
        //LazyBean1 lb1 = annotationConfigApplicationContext.getBean("lazyBean1",LazyBean1.class);
        try{
            throw new Exception("aaaaaaa");
        }catch (Exception e){
            //e.printStackTrace();
            logger.error("aaaaaaaa{}","1111111",e);
        }
    }


}
