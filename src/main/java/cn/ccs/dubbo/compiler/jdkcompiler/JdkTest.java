package cn.ccs.dubbo.compiler.jdkcompiler;

import com.alibaba.dubbo.common.compiler.support.JdkCompiler;

/**
 * Created by ccs on 2017/6/17.
 */
public class JdkTest {
    public static void main(String[] args) {
        String src = "package com;"
                + "public class TestCompiler {"
                + "	public void disply() {"
                + "	System.out.println(\"Hello\");"
                + "}}";

        JdkCompiler compiler = new JdkCompiler();
        try {
            final Class<?> aClass = compiler.doCompile("com.TestCompiler", src);
            aClass.newInstance();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
