package cn.ccs.spring.value;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

/**
 * Created by chaichuanshi on 2016/10/27.
 */

@Configurable
@EnableAspectJAutoProxy
@ComponentScan(value = {"cn.ccs.spring.value"},lazyInit = false)
//@ImportResource("classpath:resources/application-local.properties")
public class SpringValueConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringValueConfig.class);
        ValueBean valueBean = annotationConfigApplicationContext.getBean(ValueBean.class);
        System.out.println(valueBean.getValue());
        System.out.println(valueBean.getName());
        PreferencesPlaceholderConfigurer phc = annotationConfigApplicationContext.getBean(PreferencesPlaceholderConfigurer.class);
        phc.hashCode();

        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor;
    }


//    @Bean(name="propertyConfigurer")
//    public PropertiesFactoryBean getPropertiesFactoryBean(){
//        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//        propertiesFactoryBean.setLocation(new ClassPathResource("application-local.properties"));
//        return  propertiesFactoryBean;
//    }

    @Bean(name="propertyConfigurer")
    public PropertiesFactoryBean getPropertiesFactoryBean(){
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();

        //getPreferencesPlaceholderConfigurer().

        propertiesFactoryBean.setLocation(new ClassPathResource("application-local.properties"));
        return  propertiesFactoryBean;
    }

    @Bean(name="preferencesPlaceholderConfigurer")
    public PreferencesPlaceholderConfigurer getPreferencesPlaceholderConfigurer(){
        PreferencesPlaceholderConfigurer preferencesPlaceholderConfigurer = new PreferencesPlaceholderConfigurer();
        //preferencesPlaceholderConfigurer.setProperties(getPropertiesFactoryBean());
        preferencesPlaceholderConfigurer.setLocation(new ClassPathResource("application-local.properties"));
        return  preferencesPlaceholderConfigurer;
    }


}
