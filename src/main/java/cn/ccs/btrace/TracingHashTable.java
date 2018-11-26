package cn.ccs.btrace;

import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class TracingHashTable {
	
//	@OnMethod(clazz = "cn.ccs.btrace.DemoThread", method = "getA", location = @Location(Kind.ENTRY))
//	public static void traceExecute(@Self Object object,String id,@Return String map , @Duration long time) {
//		println("调用堆栈！！");
//		BTraceUtils.println("parameter  object = "+ object );
//		BTraceUtils.println("parameter  id = "+ id );
//		BTraceUtils.println("result  map = "+ map );
//		BTraceUtils.println("cost  time = "+ time );
//		jstack();
//	}

//	@OnMethod(clazz = "cn.ccs.btrace.DemoThread", method = "getA",location = @Location(Kind.RETURN))
//	public static void trace(@Duration long time,@Return String res) {
//		println("调用堆栈！！");
//		BTraceUtils.println("cost  time = "+ time );
//		BTraceUtils.println("res result = "+ res );
//		//jstack();
//	}

//	@OnMethod(clazz = "java.util.HashMap", method = "put",location = @Location(Kind.RETURN))
//	public static void traceMap(@Duration long time ,@Return Object res) {
//		println("调用堆栈！！");
//		BTraceUtils.println("cost  time = "+ time );
//		BTraceUtils.println("res result = "+ res );
//		jstack();
//	}
	@OnMethod(clazz = "cn.ccs.demo.controller.MyController", method = "getAuditManual2",location = @Location(Kind.RETURN))
	public static void tracecontroller(@Duration long time
			//,@Return Object res
	) {
		println("调用堆栈！！");
		BTraceUtils.println("cost  time = "+ time );
		//BTraceUtils.println("res result = "+ res );
		jstack();
		Sys.Env.printEnv();
		//jstackAll();
	}
}
