package cn.ccs.map;

import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

public class TestMap {


    public static void main(String[] args) {
        for(int i=0;i<3;i++) {
            new Thread(){
                @Override
                public void run(){
                    new TestMap().testSortMap();
                }
            }.start();

        }
    }
    public void testSortMap(){

        SortedMap<String,String> map = new TreeMap<>();
        int i = 0 ;
        while(true){
            int count = 0;
            count ++;
            while(count < 1000) {
                i++;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
