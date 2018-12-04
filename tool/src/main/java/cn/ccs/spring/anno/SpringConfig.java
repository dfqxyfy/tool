package cn.ccs.spring.anno;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by chaichuanshi on 2016/10/27.
 */

@Configurable
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "cn.ccs.spring.anno")
public class SpringConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Processor p = annotationConfigApplicationContext.getBean(Processor.class);
        p.proc();
    }
}
