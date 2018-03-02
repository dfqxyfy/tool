package com;

import org.springframework.context.ApplicationContext;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class MyTest {


    private static final LinkedBlockingQueue<List<String>> queue = new LinkedBlockingQueue<List<String>>();

    public static void main(String[] args) throws UnsupportedEncodingException {
//
//
//
//        while(true){
//            try {
//                queue.take();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }

        Object o = null;
        System.out.println((List)o);
    }
}
