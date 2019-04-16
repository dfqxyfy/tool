package cn.ccs.jvm;

import java.util.ArrayList;
import java.util.List;

public class MyThreadMemory {

    public static void main(String[] args) {
        Thread thread = new Thread();

        List list = new ArrayList<>();
        int num = 0;
        String str = "";
        while(true) {
            num++;
            str="abcdefgh";
            //list.add(new Object());
            list.add(str);
            if (num % 1000 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(num%50000==0){
                //list= new ArrayList();
                //System.out.println("over....");
                //break;
            }
        }

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
class MyRun implements Runnable{

    @Override
    public void run() {

    }
}
