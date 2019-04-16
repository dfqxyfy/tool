package cn.ccs.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk8  -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m
 */
public class RuntimeConstantPoolOOM {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}