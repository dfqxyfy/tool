package cn.ccs.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

/**
 * Created by chaichuanshi on 2016/10/27.
 */

@Configurable

@ComponentScan(basePackages = "cn.ccs.spring.event")
public class SpringConfig {

    @Autowired
    CcsPublisher publisher;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        ApplicationEvent applicationEvent = new CcsApplicationEvent(annotationConfigApplicationContext);
        //annotationConfigApplicationContext.publishEvent(applicationEvent);

        CcsPublisher publisher = annotationConfigApplicationContext.getBean(CcsPublisher.class);
        publisher.pub(applicationEvent);

    }

    @PostConstruct
    public void bean(){

    }

}
