package com.ccs;

import org.junit.Test;

import java.util.*;

/**
 * Created by ccs on 2016/12/23.
 */
public class JunitTest {

    @Test
    public void cladfs(){
        System.out.println(System.getProperty("count"));
        System.out.println(System.getProperty("count2"));
        System.out.println("aaaaaaaaa");

        Properties p  = System.getProperties();
        Set<String> sets =p.stringPropertyNames();

        List<String> list = new ArrayList<>();
        for(String s:sets){
            list.add(s);
        }
        Collections.sort(list);
        list.forEach(s->{
            System.out.println(s+"  -->  "+p.getProperty(s));
        });

    }
}
