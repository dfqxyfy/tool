package cn.ccs.proxy;

/**
 * Created by chaichuanshi on 2017/5/17.
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getName(int id) {
        System.out.println("name:"+id);
        return "name:"+id;
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("age:"+id);
        return id;
    }
}
