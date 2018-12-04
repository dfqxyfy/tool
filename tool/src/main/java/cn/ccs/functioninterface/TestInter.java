package cn.ccs.functioninterface;

public class TestInter {
    public static void main(String[] args) {
        MyInvoke myInvoke = null;

        myInvoke.invoke(myi->{
            System.out.println(myi);
            return myi;
        });
    }
}
