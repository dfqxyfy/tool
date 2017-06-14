package cn.ccs.spring.resource;//package cn.ccs.spring.resource;
//
//import cn.ccs.spring.resource.bean.ResourceInterface;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.annotation.Resource;
//
///**
// * Created by chaichuanshi on 2017/3/3.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpringResourceConfig.class)
//public class JunitSpringTest {
//    @Resource
//    ResourceInterface resourceInterface;
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Test
//    public void adsfs(){
//        System.out.println(resourceInterface.getName());;
//    }
//
//
//
//    public void adf(){
//        new JunitSpringTest(){
//            @Override
//            public void adsfs(){
//                System.out.println(resourceInterface.getName());
//            }
//        }.adsfs();
//    }
//
//}
