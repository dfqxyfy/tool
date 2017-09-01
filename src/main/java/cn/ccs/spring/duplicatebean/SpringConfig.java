package cn.ccs.spring.duplicatebean;

import cn.ccs.spring.anno.FactoryBean;
import cn.ccs.spring.anno.InnerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;
import java.util.Map;

/**
 * Created by chaichuanshi on 2016/10/27.
 */

@Configurable
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "cn.ccs.spring.duplicatebean")
public class SpringConfig {

    @Bean(name = "methodProc")
    public DubProcessor getB(){
        return new DubProcessor();
    }


    @Autowired
    List<DubProcessor> listBean;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        DubProcessor processor = annotationConfigApplicationContext.getBean("processor", DubProcessor.class);


    }

}
