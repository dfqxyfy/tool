package cn.ccs.springanno;

import cn.ccs.spring.anno.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;

/**
 * Created by chaichuanshi on 2017/2/14.
 */
@Configurable
@ComponentScan(basePackages = "cn.ccs.springanno")
public class SpringAnno {

    @Bean(name="factoryBean")
    FactoryBean getBean() {
        return new FactoryBean();
    }

    @Bean(name = "methodProc")
    public Processor getB(){
        return new Processor();
    }
    @Bean(name = "methodProc2")
    public Processor getB2(){
        return new Processor();
    }
    @Bean(name = "methodProc3")
    public Processor getB3(){
        return new Processor();
    }

    @Autowired
    private Processor processor;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringAnno.class);

        Map<String,Object> mapAutowired = annotationConfigApplicationContext.getBeansWithAnnotation(Autowired.class);
        Map<String,Object> beanAutowired = annotationConfigApplicationContext.getBeansWithAnnotation(Bean.class);

        System.out.println("***********");
        mapAutowired.forEach((s,o)->{
            System.out.print(s + "_" + o.getClass());
        });
        beanAutowired.forEach((s,o)->{
            System.out.print(s + "_" + o.getClass());
        });
    }
}
