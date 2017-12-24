package cn.ccs.swap;

import java.lang.reflect.Field;

public class SwapInteger {

    public static void main(String[] args) throws Exception {
        Integer a = new Integer(1);
        Integer b = new Integer(2);

        swap(a,b);
        System.out.println(a);
        System.out.println(b);
    }

    public static void swap(Integer a,Integer b) throws Exception{
        final Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        Integer temp = new Integer(a);
        field.set(a,b);
        field.set(b,temp);

    }
}
