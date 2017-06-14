package cn.ccs.spring.resource.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by chaichuanshi on 2017/3/3.
 */
public class ResourceMethodReplace implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("replacemethod......");
        return null;
    }
}
