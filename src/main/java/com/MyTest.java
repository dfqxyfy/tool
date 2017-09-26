package com;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MyTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "&middot;";
        s="图荪娜依·阿吾提";
        String s2 = URLEncoder.encode(s,"utf-8");
        System.out.println(s2);

        String s3 = URLDecoder.decode(s2,"utf-8");
        System.out.printf(s3);
    }
}
