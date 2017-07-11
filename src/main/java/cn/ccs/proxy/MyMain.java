package cn.ccs.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chaichuanshi on 2017/7/7.
 */
public class MyMain {

    public static void main(String[] args) {
        UserService userService = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("getAge"))
                    return 3;
                else
                    return "3333";
            }
        });
        Integer age = userService.getAge(1);
        String name = userService.getName(3);
        System.out.println(age+":" +name);
    }

//    public static void main(String[] args) {
//
//        Object o = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
//                UserService.class.getInterfaces(),
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////                        if (method.getName().equals("getName")) {
////                            return method.invoke(this, "bunny");
////                        }
//                        return null;
//                    }
//                });
//        System.out.println(((UserService)o).getName(3));
//
//    }

}
