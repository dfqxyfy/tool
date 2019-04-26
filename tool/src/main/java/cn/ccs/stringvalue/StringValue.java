package cn.ccs.stringvalue;

public class StringValue {
    public static void main(String[] args) {
        String s="";
        for(int i=0;i<1000;i++){
            s+="a";
        }
        long l1 = System.nanoTime();
        for(int i=0;i<10000;i++){
            int c= s.length();
        }
        long l2 = System.nanoTime();
        int l=s.length();
        for(int i=0;i<10000;i++){
            int c=l;
        }
        long l3 = System.nanoTime();
        System.out.println(l2-l1);
        System.out.println(l3-l2);
    }
}
