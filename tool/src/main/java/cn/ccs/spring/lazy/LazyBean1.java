package cn.ccs.spring.lazy;

import org.springframework.stereotype.Component;

/**
 * Created by chaichuanshi on 2016/11/14.
 */
@Component("lazyBean1")
public class LazyBean1 {
    public LazyBean1(){
        System.out.println("lazybean 1.....");
    }
}
