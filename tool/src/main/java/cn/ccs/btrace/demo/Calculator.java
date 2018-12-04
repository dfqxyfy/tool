package cn.ccs.btrace.demo;

public class Calculator {
    public int add(int a, int b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }
}