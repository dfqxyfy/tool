package cn.ccs.rpc;

/**
 * Created by chaichuanshi on 2017/5/24.
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
