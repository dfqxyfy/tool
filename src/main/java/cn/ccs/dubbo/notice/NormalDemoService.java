package cn.ccs.dubbo.notice;

/**
 * Created by chaichuanshi on 2017/5/16.
 */
public class NormalDemoService implements IDemoService {
    @Override
    public Person get(int id) {
        Person p = new Person();
        p.setName("aaaa");
        return p;
    }
}
