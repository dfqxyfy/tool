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

        System.out.println("adffsaf.32413sad".split("\\.")[0]);
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

//        final   ThreadLocal<String> threadLocal = new ThreadLocal<>();
//        final   ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
//        threadLocal.set("aaa");
//        if(true){
//            return;
//        }
        for(int i=0;i<1;i++) {
            new Thread(){
                @Override
                public void run(){

                    final   ThreadLocal<String> threadLocal = new ThreadLocal<>();
                    //final   ThreadLocal<String> threadLocal2 = new ThreadLocal<>();

                    threadLocal.set("aaa");


                    final   ThreadLocal<String> threadLocal2 = new ThreadLocal<>();


                    threadLocal2.set("bbb");


                    final   ThreadLocal<String> threadLocal3= new ThreadLocal<>();


                    threadLocal3.set("ccc");
                }
            }.start();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Object o = null;
            System.out.println((List) o);
        }
    }
}
