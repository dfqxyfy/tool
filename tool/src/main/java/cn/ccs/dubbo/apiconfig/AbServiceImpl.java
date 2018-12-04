package cn.ccs.dubbo.apiconfig;

/**
 * Created by chaichuanshi on 2017/5/15.
 */
public class AbServiceImpl implements AbService {
    @Override
    public String find() {
        System.out.println("************\nabService.........\n************");
        return "************\nabService.........\n************";
    }

    @Override
    public String getName(String name, Integer age) {
        return name + " " + age;
    }
}
