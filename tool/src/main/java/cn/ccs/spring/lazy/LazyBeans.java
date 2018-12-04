package cn.ccs.spring.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chaichuanshi on 2016/11/14.
 */
@Component(value="lazyBeans")
public class LazyBeans {

    @Autowired(required = false)
    LazyBean1 lazyBean1;

    public LazyBeans(){
        System.out.println("lazybeans init.....");
    }

    public void testLazyBean1(){
        System.out.println(lazyBean1.hashCode());
    }
}
