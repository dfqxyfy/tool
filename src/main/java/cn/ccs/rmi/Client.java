package cn.ccs.rmi;

/**
 * Created by chaichuanshi on 2017/5/17.
 */

import javax.naming.Context;
import javax.naming.InitialContext;

public class Client {
    public static void main(String[] args) {
        try {
            Context namingContext = new InitialContext();
            // 检索指定的对象。 即找到服务器端相对应的服务对象存根
            IService service02 = (IService) namingContext.lookup("rmi://localhost:8888/service02");
            Class stubClass = service02.getClass();
            System.out.println(service02 + " 是 " + stubClass.getName()
                    + " 的实例！");
            // 获得本底存根已实现的接口类型
            Class[] interfaces = stubClass.getInterfaces();
            for (Class c : interfaces) {
                System.out.println("存根类实现了 " + c.getName() + " 接口！");
            }
            System.out.println(service02.service("你好！"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}