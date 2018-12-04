package cn.ccs.proxy.jdk;

import cn.ccs.proxy.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chaichuanshi on 2017/5/24.
 */
public class TestNullClassImpl {

    public static void main(String[] args) {
        UserService userService = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{
                UserService.class,
        }, new TempMyInvocationHandler());

        System.out.println(userService.getAge(3));;
        System.out.println(userService.getName(33));
    }
}

class TempMyInvocationHandler implements InvocationHandler{

    private String str = "aaaa";
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("getName".equals(method.getName()))
            return "getName";
        if("getAge".equals(method.getName()))
            return 1;
        return null;
    }

}