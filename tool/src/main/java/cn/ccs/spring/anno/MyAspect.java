//package cn.ccs.spring.anno;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
///**
// * Created by chaichuanshi on 2016/12/19.
// */
//@Aspect
//@Component
//public class MyAspect {
//    @Around("@annotation(cn.ccs.spring.anno.MyMethodAnno)")
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//        System.out.println(point.getSignature());
//        Long start = System.currentTimeMillis();
//        Object o = point.proceed(point.getArgs());
//        Long end = System.currentTimeMillis();
//        System.out.println("Around消耗时间："+(end-start));
//        return o;
//    }
//
//
//    @Before("@annotation(cn.ccs.spring.anno.MyMethodAnno)")
//    public void around(JoinPoint point) throws Throwable {
//        System.out.println(point.getSignature());
//        Long start = System.currentTimeMillis();
//        Long end = System.currentTimeMillis();
//        System.out.println("Before 消耗时间："+(end-start));
//    }
//}
