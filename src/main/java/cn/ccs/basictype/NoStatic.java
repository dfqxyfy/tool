package cn.ccs.basictype;

/**
 * Created by chaichuanshi on 2017/7/12.
 */
public class NoStatic {
    private static int i = 10;

//    static {
//        i = 20;
//    }

    public static void main(String[] args) {
        System.out.println(i);
    }

}
