package cn.ccs.agent;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(0));
        list.add(new Integer(2));
        list.add(new Integer(3));
        for(Integer i:list){
            System.out.print(i+"\t");
        }
        System.out.println();
        list.remove(new Integer(2));
        for(Integer i:list){
            System.out.print(i+"\t");
        }

    }
}
