package cn.ccs.method;

public class MyMethod {
    public static void main(String[] args) throws NoSuchMethodException {

        for(String s:args){
            System.out.println(s);
        }
        System.out.println(MyMethod.class.getMethod("main",String[].class));
    }
}
