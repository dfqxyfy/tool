package cn.ccs.spring.source;

import cn.ccs.spring.Processor;
import cn.ccs.spring.anno.FactoryBean;
import cn.ccs.spring.anno.InnerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * Created by chaichuanshi on 2016/10/27.
 */

@Configurable

@PropertySource("application.properties")
@ComponentScan(basePackages = "cn.ccs.spring.source")
public class SpringConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Processor p = annotationConfigApplicationContext.getBean(Processor.class);
        p.proc();

        ScanTest st = annotationConfigApplicationContext.getBean(ScanTest.class);
        System.out.println(st.getStr());

    }

    @Bean
    public Processor getP(){
        return new Processor();
    }
}
