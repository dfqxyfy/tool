package cn.ccs.dubbo.wrapper;

import java.io.OptionalDataException;

/**
 * Created by ccs on 2017/7/9.
 */
public class TempWrapper extends com.alibaba.dubbo.common.bytecode.Wrapper{

    public void setPropertyValue(Object o, String n, Object v) {
        cn.ccs.dubbo.apiconfig.AbService w;
        try {
            w = ((cn.ccs.dubbo.apiconfig.AbService) o);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        throw new com.alibaba.dubbo.common.bytecode.NoSuchPropertyException("Not found property \"" + n + "\" filed or setter method in class cn.ccs.dubbo.apiconfig.AbService.");
    }


    public Object getPropertyValue(Object o, String n) {
        cn.ccs.dubbo.apiconfig.AbService w;
        try {
            w = ((cn.ccs.dubbo.apiconfig.AbService) o);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        throw new com.alibaba.dubbo.common.bytecode.NoSuchPropertyException("Not found property \"" + n + "\" filed or setter method in class cn.ccs.dubbo.apiconfig.AbService.");
    }

    public Object invokeMethod(Object o, String n, Class[] p, Object[] v) throws java.lang.reflect.InvocationTargetException {
        cn.ccs.dubbo.apiconfig.AbService w;
        try {
            w = ((cn.ccs.dubbo.apiconfig.AbService) o);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        try {
            if ("find".equals(n) && v.length == 0) {
                return (Object)w.find();
            }
        } catch (Throwable e) {
            throw new java.lang.reflect.InvocationTargetException(e);
        }
        throw new com.alibaba.dubbo.common.bytecode.NoSuchMethodException("Not found method \"" + n + "\" in class cn.ccs.dubbo.apiconfig.AbService.");
    }


    @Override
    public String[] getMethodNames() {
        return new String[0];
    }

    @Override
    public String[] getDeclaredMethodNames() {
        return new String[0];
    }

    @Override
    public String[] getPropertyNames() {
        return new String[0];
    }

    @Override
    public Class<?> getPropertyType(String pn) {
        return null;
    }

    @Override
    public boolean hasProperty(String name) {
        return false;
    }
}
