package cn.ccs.proxy.cglib;//package cn.ccs.proxy.cglib;
//
///**
// * Created by chaichuanshi on 2017/5/17.
// */
//import cn.ccs.proxy.UserService;
//import cn.ccs.proxy.UserServiceImpl;
//import net.sf.cglib.proxy.Enhancer;
//
//
//
//public class Main2 {
//    public static void main(String[] args) {
//        CglibProxy cglibProxy = new CglibProxy();
//
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(UserServiceImpl.class);
//        enhancer.setCallback(cglibProxy);
//
//        UserService o = (UserService)enhancer.create();
//        o.getName(1);
//        o.getAge(1);
//    }
//}