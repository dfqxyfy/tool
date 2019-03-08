package cn.ccs.javaagent;

import java.lang.instrument.Instrumentation;

public class HelloAgent {
 
	public static void premain(String arg, Instrumentation instrumentation) {
		System.err.println("装载成功 方法 premain 参数：" + arg);
		StringBuilder str = new StringBuilder();
		for(int i=0;i<5;i++) {
			str.append("aaa");
		}
		System.out.println(str);
	}
}