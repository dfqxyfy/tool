package cn.ccs.proxy.ext;

import cn.ccs.proxy.UserService;
import cn.ccs.proxy.UserServiceImpl;
import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chaichuanshi on 2017/5/22.
 */
public class MyProxy {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        MyProxy mp = new MyProxy();

        MyInVocationHandler handler = new MyInVocationHandler() ;
        handler.obj = userService;

        Object result = Proxy.newProxyInstance( Thread.currentThread().getContextClassLoader(),
                new Class[]{ UserService.class,MyProxyInterface.class, },handler
                );


        System.out.println(((UserService)result).getAge(3));;
        System.out.println(((MyProxyInterface)result).getAge(3));;
    }

}

class MyInVocationHandler implements InvocationHandler{
    public Object obj;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("..............");
        Object o = method.invoke(obj,args);
        System.out.println("..............");
        ProxyGenerator pg;
        return o;
    }
}