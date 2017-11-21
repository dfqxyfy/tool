package com.ccs.excel;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestAtmotic {
    public static void main(String[] args) {

        AtomicBoolean atomicBoolean = new AtomicBoolean(true);

        for(int i = 0;i<100;i++) {
            boolean flag = true;
            if(i%2==0) {
                flag = atomicBoolean.compareAndSet(true, false);
                System.out.println(i+"---"+flag);
            }else{
                flag = atomicBoolean.compareAndSet(false, true);
            }
        }
    }
}
