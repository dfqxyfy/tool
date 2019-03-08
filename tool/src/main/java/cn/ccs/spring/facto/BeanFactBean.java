package cn.ccs.spring.facto;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class BeanFactBean {
    public static void main(String[] args) {
        Resource resource = new FileSystemResource("beans.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml", "applicationContext-part2.xml"});
        BeanFactory factory2 = (BeanFactory) context;
    }
}
