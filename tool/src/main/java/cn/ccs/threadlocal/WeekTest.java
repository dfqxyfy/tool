package cn.ccs.threadlocal;

import java.util.WeakHashMap;


public class WeekTest {

    public static class Locker {
        private static WeakHashMap<String, Locker> lockerMap = new WeakHashMap<String, Locker>();
        private final String id;
        private Locker(String id) {
            this.id= id;
        }
        public synchronized static Locker acquire(String id) {
            Locker locker = lockerMap.get(id);
            if (locker == null) {
                locker = new Locker(id);
                //lockerMap.put(id, locker);  //问题代码，导致了entry.key == entry.value.id
                lockerMap.put(new String(id), locker);  //这是一种修改方式，保证了WeakHashMap中的key，没有被value直接或间接所引用
            }
            return locker;
        }
        public String getId() {
            return this.id;
        }
        public static int getSize() {
            return lockerMap.size();
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            Locker.acquire("abc" + i);
            if (i % 10000 == 0) {
                System.gc();
                System.out.println(Locker.getSize());    //输出垃圾回收后的Map的Size
            }
        }

    }
}