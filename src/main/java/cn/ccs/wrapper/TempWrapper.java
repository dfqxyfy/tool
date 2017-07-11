package cn.ccs.wrapper;

import com.alibaba.dubbo.common.bytecode.Wrapper;

import java.util.Map;

/**
 * Created by chaichuanshi on 2017/7/10.
 */
public class TempWrapper extends Wrapper {

    public static String[] pns; // property name array.
    public static java.util.Map pts;// property type map.
    public static String[] mns; // all method name array.
    public static String[] dmns;; // declared method name array.

    public static Class[] mts0;
    public static Class[] mts1;

    public Object invokeMethod(Object o, String n, Class[] p, Object[] v) throws java.lang.reflect.InvocationTargetException {
        cn.ccs.dubbo.apiconfig.AbServiceImpl w;
        try {
            w = ((cn.ccs.dubbo.apiconfig.AbServiceImpl) o);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        try {
            if ("getName".equals(n) && p.length == 2) {
                return (String) w.getName((java.lang.String) v[0], (java.lang.Integer) v[1]);
            }
            if ("find".equals(n) && p.length == 0) {
                return (String) w.find();
            }
        } catch (Throwable e) {
            throw new java.lang.reflect.InvocationTargetException(e);
        }
        throw new com.alibaba.dubbo.common.bytecode.NoSuchMethodException("Not found method \"" + n + "\" in class cn.ccs.dubbo.apiconfig.AbServiceImpl.");
    }

    public void setPropertyValue(Object o, String n, Object v) {
        cn.ccs.dubbo.apiconfig.AbServiceImpl w;
        try {
            w = ((cn.ccs.dubbo.apiconfig.AbServiceImpl) o);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        throw new com.alibaba.dubbo.common.bytecode.NoSuchPropertyException("Not found property \"" + n + "\" filed or setter method in class cn.ccs.dubbo.apiconfig.AbServiceImpl.");
    }

    public Object getPropertyValue(Object o, String n) {
        cn.ccs.dubbo.apiconfig.AbServiceImpl w;
        try {
            w = ((cn.ccs.dubbo.apiconfig.AbServiceImpl) o);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
        throw new com.alibaba.dubbo.common.bytecode.NoSuchPropertyException("Not found property \"" + n + "\" filed or setter method in class cn.ccs.dubbo.apiconfig.AbServiceImpl.");
    }

    public String[] getPropertyNames(){ return pns; }

    public boolean hasProperty(String n){ return pts.containsKey(n); }
    public Class getPropertyType(String n){ return (Class)pts.get(n); }
    public String[] getMethodNames(){ return mns; }
    public String[] getDeclaredMethodNames(){ return dmns; }

}
