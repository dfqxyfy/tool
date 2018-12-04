package cn.ccs.btrace.demo;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.println;

@BTrace(unsafe = true)

public class BTraceTest {

    @OnMethod(clazz = "cn.ccs.btrace.demo.Calculator", method = "add", location = @Location(Kind.RETURN))

    public static void traceTest(int a, int b, @Return int sum) {

        println(String.format("%d + %d = %d", a, b, sum));

    }

}