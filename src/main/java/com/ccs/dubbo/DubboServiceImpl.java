package com.ccs.dubbo;

/**
 * Created by ccs on 2017/5/12.
 */
public class DubboServiceImpl implements DubboService {
    @Override
    public String sayHello(String s) {
        System.out.println(s);
        return "service:"+s;
    }
}
