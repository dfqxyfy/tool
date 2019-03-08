package cn.temp.interfaces;

public class ImplAB implements IA,IB {
    public void aa(){
        System.out.println("bb");
    }

    public static void main(String[] args) {
        ImplAB ab = new ImplAB();
        ab.aa();
    }
}
