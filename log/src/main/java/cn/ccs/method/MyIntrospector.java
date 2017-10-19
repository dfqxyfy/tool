package cn.ccs.method;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

public class MyIntrospector {
    public static void main(String[] args) throws IntrospectionException {
        final BeanInfo beanInfo = Introspector.getBeanInfo(MyBean.class);
        System.out.println(beanInfo.getAdditionalBeanInfo());
    }
}
class MyBean{
    private String name;
    private MyMethod myMethod;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return name;
    }
}
