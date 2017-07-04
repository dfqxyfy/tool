package com.ccs.thinkinginjava;

import org.junit.Test;

/**
 * Created by chaichuanshi on 2017/6/29.
 */
public class BasicTypeTest {
    @Test
    public void classBasicType() {
        for (int i = 0; i < 100; i++) {
            A a = new A();
            //if (a.x != 0)
                System.out.println(a.x);
        }
    }
}

class A {
    public int x;
}
