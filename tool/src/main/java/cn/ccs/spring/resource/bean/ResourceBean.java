package cn.ccs.spring.resource.bean;

import org.springframework.stereotype.Component;

/**
 * Created by chaichuanshi on 2016/11/14.
 */
@Component
public class ResourceBean implements ResourceInterface {
    public ResourceBean(){
        System.out.println("ResourceBean init.....");
    }

    //@Rep
    public void test(){
        System.out.println("test resourcebean......");
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
