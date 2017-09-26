//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.ccs.log;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Category;

public class CcsHierarchy {

    String name  = "org.apache.log";
    private Hashtable ht = new Hashtable();

    private final void updateParents() {
        String name = this.name;
        int length = name.length();
        boolean parentFound = false;

        for(int i = name.lastIndexOf(46, length - 1); i >= 0; i = name.lastIndexOf(46, i - 1)) {
            String substr = name.substring(0, i);
            String key = substr;
            Object o = this.ht.get(key);
            if (o == null) {
                this.ht.put(key, "value:"+substr);
            } else {
                if (o instanceof Category) {
                    parentFound = true;
                    break;
                }

            }
        }

    }

    public static void main(String[] args) {
        CcsHierarchy h = new CcsHierarchy();
        h.updateParents();

        System.out.println(HashMap.class.isAssignableFrom(Map.class));
        System.out.println(Map.class.isAssignableFrom(HashMap.class));
    }
}
