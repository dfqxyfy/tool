package cn.ccs.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class TracingMongo {

    @OnMethod(clazz = "com.mongodb.MongoBatchCursorAdapter", method = "next",location = @Location(Kind.RETURN))
    public static void trace(@Duration long time) {
        BTraceUtils.println("调用堆栈！！");
        BTraceUtils.println("cost  time = "+ time );
    }
}
