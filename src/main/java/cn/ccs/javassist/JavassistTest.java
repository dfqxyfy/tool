package cn.ccs.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.reflect.Method;

/**
 * Created by chaichuanshi on 2017/5/23.
 */
public class JavassistTest {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        //设置目标类的路径，确保能够找到需要修改的类，这里我指向firestorm.jar
        //解包后的路径
        pool.insertClassPath("E:\\workspace\\test\\build\\classes\\main") ;

        //获得要修改的类
        CtClass cc = pool.get("hello.HelloWorld");
        //设置方法需要的参数
        //CtClass[] param = new CtClass[1] ;
        //param[0] = pool.get("String") ;
        //param[0] = pool.get("java.security.PublicKey") ;
        //param[1] = pool.get("byte[]") ;
        //param[2] = pool.get("byte[]") ;

        cc.setInterfaces(new CtClass[]{pool.get("cn.ccs.javassist.Hello")});

        //得到方法
        CtMethod m = cc.getDeclaredMethod("res");

        CtClass[] parameterTypes = m.getParameterTypes();
        for(CtClass ctClass:parameterTypes){
            System.out.println(ctClass.getName());
        }
        //插入新的代码
        //m.insertBefore("{ System.out.println(\"insertBefore222 insert success\" ); }") ;
        m.setBody("{ System.out.println(\"insert2 success\" ); return \"insert success\";}");
        //m.insertParameter();
        //保存到文件里
        cc.writeFile("C:\\Users\\chaichuanshi\\Desktop\\temp") ;

        MyClassLoader cl = new MyClassLoader();
        //cl.loadClass("cn.ccs.javassist.Hello");
        Class clazz = cl.defineClass("hello.HelloWorld",cc.toBytecode());
        Object obj = clazz.newInstance();

        Hello hello = (Hello)obj;
        System.out.println(hello.res("333"));
//        for(Method method:clazz.getMethods()){
//            if("res".equals(method.getName())){
//                System.out.println(method.invoke(obj,"33"));
//            }
//        }
        //Method method = new Method();
    }
}

class MyClassLoader extends ClassLoader{

    public MyClassLoader(){
        //super(Thread.currentThread().getContextClassLoader());
    }

   public Class defineClass(String name ,byte[] bytes){

       //Thread.currentThread().getContextClassLoader().

       return super.defineClass(name,bytes,0,bytes.length);
   }


}
