package cn.ccs.proxy.jdk;

/**
 * Created by chaichuanshi on 2017/5/17.
 */

import cn.ccs.proxy.UserService;
import cn.ccs.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Main1 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
        Object o = Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), invocationHandler);
        System.out.println(o.getClass());
        Class<?>[] interfaces = o.getClass().getInterfaces();
        for(Class c:interfaces){
            System.out.println(c);
        }
        UserService userServiceProxy = (UserService)o;

        System.out.println(userServiceProxy.getName(1));
        System.out.println(userServiceProxy.getAge(1));
    }
}