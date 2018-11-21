package cn.ccs.locksync.aqs;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class QueuedSynchTest {
    public static void main(String[] args) {
        AbstractQueuedSynchronizer abstractQueuedSynchronizer ;

        try {
            final Unsafe unsafe = getUnsafe() ;//Unsafe.getUnsafe();
            System.out.println(unsafe.objectFieldOffset(Obj.class.getDeclaredField("aint")));
            System.out.println(unsafe.objectFieldOffset(Obj.class.getDeclaredField("along")));
            System.out.println(unsafe.objectFieldOffset(Obj.class.getDeclaredField("astr")));
            System.out.println(unsafe.objectFieldOffset(Obj.class.getDeclaredField("aLong")));

            //Obj obj = new Obj();
            System.out.println("********");
            System.out.println(unsafe.arrayBaseOffset(Obj[].class));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe)field.get(null);
        } catch (Exception e) {
        }
        return null;
    }

}

class Obj {
    int aint;
    long along;
    String astr;
    Long aLong;
}

class AQStest extends AbstractQueuedSynchronizer{
    protected AQStest() {
        super();
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}