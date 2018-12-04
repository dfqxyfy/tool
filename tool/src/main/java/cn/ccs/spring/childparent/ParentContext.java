package cn.ccs.spring.childparent;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Map;

/**
 * Created by chaichuanshi on 2016/10/27.
 */

@Configurable
@ComponentScan(basePackageClasses = {ParentContext.class})
public class ParentContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext(ParentContext.class);
        AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext(ChildContext.class);
        childContext.setParent(parentContext);

        //out("parent",parentContext);
        //childContext.destroy();
        out("child",childContext);
        out("parent",parentContext);

        TestBean tb =(TestBean)childContext.getBean("parentBean");
        System.out.println(tb);
    }

    private static void out(String flag,AnnotationConfigApplicationContext context){
        Map<String, TestBean> beansOfType = context.getBeansOfType(TestBean.class,false,false);
        System.out.println(flag + ".........");
        beansOfType.forEach((k,v)->{
            System.out.print(k + ":" + v);
            System.out.print(" , ");
        });
        System.out.println();
        System.out.println(flag + ".........");
    }

    public void aaa(String aa,String bb){
        System.out.println("aaa,"+aa);
    }

    @Bean(name="parentBean")
    public TestBean getTestBean(){
        TestBean testBean = new TestBean(ParentContext.class);
        return testBean;
    }

}
