//package cn.ccs.spring.anno;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.Map;
//
///**
// * Created by chaichuanshi on 2016/12/19.
// */
//public class MainApp {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
////        annotationConfigApplicationContext.register(SpringConfig.class);
////        annotationConfigApplicationContext.register(Processor.class);
////        annotationConfigApplicationContext.register(MyAspect.class);
//        //annotationConfigApplicationContext.refresh();
//        MyAspect my = annotationConfigApplicationContext.getBean(MyAspect.class);
//        Map<String, Object> res = annotationConfigApplicationContext.getBeansWithAnnotation(MyClassAnno.class);
//
//        System.out.println("............................");
//        res.forEach((String k, Object v) ->{
//            System.out.println(v.getClass());
//            if( v instanceof Processor){
//                ((Processor) v).proc();
//            }
//        });
//
//
//
//        //System.out.println(my==null);
//    }
//
//}
