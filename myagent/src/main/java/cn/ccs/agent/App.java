package cn.ccs.agent;
 
import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 */
public class App {
    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("=========premain方法执行========");
        System.out.println(agentOps);
        // 添加Transformer
        inst.addTransformer(new FirstAgent());
    }
}
