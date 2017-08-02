package cn.ccs.dubbo;

import cn.ccs.dubbo.notice.Person;

/**
 * Created by chaichuanshi on 2017/5/16.
 */
public interface DubboService {
    String sayHello(String world);
    Person getPerson(int id);
}
