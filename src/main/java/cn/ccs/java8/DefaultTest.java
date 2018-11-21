package cn.ccs.java8;

public class DefaultTest extends AbsDef implements DefIntf{

    public static void main(String[] args) {
        DefaultTest dt = new DefaultTest();
        dt.dmethod("abc");

    }

//    @Override
//    public void dmethod(String value) {
//        System.out.println();
//    }
}

interface DefIntf{
    default void dmethod(String value){
        System.out.println("interface value "+value);
    }
}
class AbsDef{
    public void dmethod(String value){
        System.out.println("abstract class value "+value);
    }
}