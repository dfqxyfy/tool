package cn.ccs.dubbo.compiler.jdkcompiler;

/**
 * Created by ccs on 2017/6/17.
 */
import com.alibaba.dubbo.common.compiler.support.JdkCompiler;
import com.alibaba.dubbo.common.utils.ClassHelper;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class CompilerMain {
    public static void main(String[] args) throws Exception {
        testCompiler();
    }

    public static void testCompiler() throws Exception {
        String currentDir = "D:/temp";//System.getProperty("user.dir");
        // 將源码写入文件中
        String src = "package com;"
                + "public class TestCompiler {"
                + "	public void disply() {"
                + "	System.out.println(\"Hello\");"
                + "}}";
        String filename = currentDir + "/com/TestCompiler.java";
        File file = new File(filename);
        FileWriter fw = new FileWriter(file);
        fw.write(src);
        fw.flush();
        fw.close();
        // 使用JavaCompiler 编译java文件
        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = jc.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> fileObjects = fileManager.getJavaFileObjects(filename);
        CompilationTask cTask = jc.getTask(null, fileManager, null, null, null, fileObjects);
        cTask.call();
        fileManager.close();
        // 使用URLClassLoader加载class到内存
        URL[] urls = new URL[]{new URL("file:/" + currentDir + "/")};
        URLClassLoader cLoader = new URLClassLoader(urls);

        //final Class<?> aClass = Class.forName("com.TestCompiler");
        //aClass.newInstance();
        //System.out.println("...................");
        //ClassLoader  cLoader =   Thread.currentThread().getContextClassLoader();
        Class<?> c = cLoader.loadClass("com.TestCompiler");

        //cLoader.close();
        // 利用class创建实例，反射执行方法
        Object obj = c.newInstance();
        Method method = c.getMethod("disply");
        method.invoke(obj);
    }
}
class MyClassLoader extends ClassLoader{
    JavaFileObject jfo ;
    public MyClassLoader(JavaFileObject jfo){
        this.jfo = jfo;
    }

    @Override
    protected Class<?> findClass(final String qualifiedClassName) throws ClassNotFoundException {
          //  byte[] bytes = jfo.getByteCode();
          //  return defineClass(qualifiedClassName, bytes, 0, bytes.length);
        try {
            return ClassHelper.forNameWithCallerClassLoader(qualifiedClassName, getClass());
        } catch (ClassNotFoundException nf) {
            return super.findClass(qualifiedClassName);
        }
    }

}