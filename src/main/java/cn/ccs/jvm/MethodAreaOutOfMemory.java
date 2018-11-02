package cn.ccs.jvm;

import java.lang.reflect.Method;

 

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


/**

 * @Described：方法区溢出测试

 * 使用技术 CBlib

 * @VM args : -XX:PermSize=10M -XX:MaxPermSize=10M

 * @author YHJ create at 2011-11-12 下午08:47:55

 * @FileNmae com.yhj.jvm.memory.methodArea.MethodAreaOutOfMemory.java

 */

public class MethodAreaOutOfMemory {


    /**
     * @param args
     * @Author YHJ create at 2011-11-12 下午08:47:51
     */

    public static void main(String[] args) {

        while (true) {

            Enhancer enhancer = new Enhancer();

            enhancer.setSuperclass(TestCase.class);

            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {

                @Override

                public Object intercept(Object arg0, Method arg1, Object[] arg2,

                                        MethodProxy arg3) throws Throwable {
                    System.out.println("intercept");
                    return arg3.invokeSuper(arg0, arg2);

                }

            });

            Object o = enhancer.create();
            ((TestCase)o).out();
            break;
        }

    }
}

class TestCase{
    public void out(){
        System.out.println("out ");
    }
}

