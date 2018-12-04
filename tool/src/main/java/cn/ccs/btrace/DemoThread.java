package cn.ccs.btrace;


public class DemoThread {

    public static void main(String[] args) {
        TempTrace temp = new TempTrace();
        System.out.println("aaa");
        for(;;) {
            try {
                long t1 = System.nanoTime();
                String a1 = temp.getA();
                long t2= System.nanoTime();
                String key = "cost " + (t2-t1) + " ms  "+ a1;
                String value = key;
                System.out.println(key);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TempTrace{
    private String aa = "10000";
    public String getA(){
        return aa;
    }
}
