package cn.ccs.jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {

    //JVM设置

    //-Xms30M -Xmx30M -Xmn10M -XX:+PrintGCDetails -XX:PermSize=10m -XX:MaxPermSize=10m -XX:+UseConcMarkSweepGC -XX:+HeapDumpOnOutOfMemoryError

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
