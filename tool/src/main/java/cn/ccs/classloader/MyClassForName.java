package cn.ccs.classloader;

public class MyClassForName {

    private static int num = 0;

    static {
        num = 100;
        System.out.println("class for name 测试成功");
    }

    public void aa(){
        System.out.println("method aa test");
        System.out.println(num);
    }
}
