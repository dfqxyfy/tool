package cn.ccs.basictype;

class SingleTon {
    public static int count2=0;
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count3 = aa();

    static {
        System.out.println("xxxx "+count2);
    }

    private SingleTon() {
        SingleTon.count1++;
        SingleTon.count2++;
        SingleTon.count3++;
    }

    public static int aa(){
        //System.out.println("aaaa"+count3);
        return count3;
    }

    static {
            count2 = 1111;
    }
    public static SingleTon getInstance() {
        return singleTon;
    }
}

public class Test1 {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
        System.out.println("count3=" + singleTon.count3);
    }
}