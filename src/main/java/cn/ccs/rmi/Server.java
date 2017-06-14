package cn.ccs.rmi;

/**
 * Created by chaichuanshi on 2017/5/17.
 */
import javax.naming.Context;
/*
* InitialContext类是执行命名操作的初始上下文。
* 该初始上下文实现 Context 接口并提供解析名称的起始点。
*/
import javax.naming.InitialContext;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        //System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        try {
            IService service02 = new ServiceImpl("service02");

            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/service02",service02);

            //实例化实现了IService接口的远程服务ServiceImpl对象

            //初始化命名空间
            //Context namingContext = new InitialContext();
            //将名称绑定到对象,即向命名空间注册已经实例化的远程服务对象
            //namingContext.rebind("rmi://127.0.0.1/service02", service02);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("服务器向命名表注册了1个远程服务对象！");
    }
}
