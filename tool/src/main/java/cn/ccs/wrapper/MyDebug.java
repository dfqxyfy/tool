package cn.ccs.wrapper;

/**
 * Created by chaichuanshi on 2017/7/10.
 */
public class MyDebug {
    public static void main(String[] args) {

        A aa = new A().gA();

        System.out.println(aa.getClass());
    }
}

class A{
    private String s;
    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }

    public  A gA(){
        final String sss = "adsf";

        return new A(){
            public String getS() {
                return sss;
            }

        };
    }
}
