package cn.ccs.rpc;

/**
 * Created by chaichuanshi on 2017/5/24.
 */
public class HelloServiceImpl implements HelloService {

    public String hello(String name) {
        return "Hello " + name;
    }

}