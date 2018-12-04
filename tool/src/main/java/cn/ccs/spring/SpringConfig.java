package cn.ccs.spring;

import cn.ccs.spring.anno.FactoryBean;
import cn.ccs.spring.anno.InnerBean;
import org.springframework.beans.factory.annotation.Autowired;
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

@ComponentScan(basePackages = "cn.ccs.spring")
public class SpringConfig {

    private String s;

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
    List<Processor> listBean;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        annotationConfigApplicationContext.register(SpringConfig.class);
//        annotationConfigApplicationContext.register(Processor.class);
//        annotationConfigApplicationContext.refresh();


        FactoryBean fb = annotationConfigApplicationContext.getBean("factoryBean",FactoryBean.class);
        fb.create();
        InnerBean ib = annotationConfigApplicationContext.getBean("innerBean",InnerBean.class);
        ib.sss();

        Processor processor = annotationConfigApplicationContext.getBean("processor", Processor.class);

        processor.proc();
        System.out.println(processor.getCount());

        //Map<String,SpringConfig> mapp22 =  annotationConfigApplicationContext.getBean(SpringConfig.class);
        SpringConfig sc = annotationConfigApplicationContext.getBean("springConfig",SpringConfig.class);




        if(sc.listBean == null ){
            System.out.println("sc listbean size "+sc.listBean.size());
        }else{
            System.out.println("**********************");
            for(Processor p:sc.listBean){

                System.out.println(p.getCount());
            }
            System.out.println("**********************");
        }
        //System.out.println(map);
        Map<String,Processor> map = annotationConfigApplicationContext.getBeansOfType(Processor.class);
        for(String s:map.keySet()){
            System.out.println(s+"__"+map.get(s).getCount());
        }
        //annotationConfigApplicationContext
        Map<String,Object> mapAutowired = annotationConfigApplicationContext.getBeansWithAnnotation(Autowired.class);
        Map<String,Object> beanAutowired = annotationConfigApplicationContext.getBeansWithAnnotation(Bean.class);

        System.out.println("***********");
        mapAutowired.forEach((s,o)->{
            System.out.print(s + "_" + o.getClass());
        });

        "h".getBytes();
    }



    public void aaa(String aa,String bb){
        System.out.println("aaa,"+aa);
    }

}
