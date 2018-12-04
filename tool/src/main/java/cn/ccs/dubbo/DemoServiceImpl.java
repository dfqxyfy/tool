package cn.ccs.dubbo;

import cn.ccs.dubbo.notice.Person;

/**
 * Created by chaichuanshi on 2017/5/16.
 */
public class DemoServiceImpl implements DubboService {
    @Override
    public String sayHello(String world) {
        return "Hello World! " + world;
    }

    @Override
    public Person getPerson(int id) {
        Person p = new Person();
        p.setName("aaaa:"+id);
        return p;
    }
}
