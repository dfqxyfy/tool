package cn.ccs.method;

public class MyMethod {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(MyMethod.class.getMethod("main",String[].class));
    }
}
