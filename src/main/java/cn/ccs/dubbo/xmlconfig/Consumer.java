package cn.ccs.dubbo.xmlconfig;

/**
 * Created by chaichuanshi on 2017/5/16.
 */
import cn.ccs.dubbo.DemoService;
import cn.ccs.dubbo.notice.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext-consumer.xml"});

        context.start();

        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果

        Person person = demoService.getPerson(333);
        System.out.println("*****************");
        System.out.println(person.getName());
        System.out.println("*****************");
    }

}