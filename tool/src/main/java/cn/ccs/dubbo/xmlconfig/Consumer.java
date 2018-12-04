package cn.ccs.dubbo.xmlconfig;

/**
 * Created by chaichuanshi on 2017/5/16.
 */
import com.ccs.dubbo.DubboService;
import cn.ccs.dubbo.notice.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext-consumer.xml"});

        context.start();

        DubboService demoService = (com.ccs.dubbo.DubboService)context.getBean("dubboService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果

        String s = demoService.sayHello("333");
        System.out.println("*****************");
        System.out.println(s);
        System.out.println("*****************");
    }

}