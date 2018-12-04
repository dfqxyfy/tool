package cn.ccs.rmi;

/**
 * Created by chaichuanshi on 2017/5/17.
 */
import java.rmi.RemoteException;
//UnicastRemoteObject用于导出的远程对象和获得与该远程对象通信的存根。
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements IService {

    private String name;

    public ServiceImpl(String name) throws RemoteException {
        this.name = name;
    }
    @Override
    public String service(String content) {
        return "server >> " + content;
    }
}