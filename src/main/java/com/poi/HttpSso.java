package com.poi;

import com.hdjf.common.pojo.thrid.sd.HttpClientUtil;

public class HttpSso {
    public static void main(String[] args) {
        String url = "http://172.16.116.136:9091/cas/login";

        String str = HttpClientUtil.sendPost(url,"ticket=ST-166-oOjYCecxcaANuys7gjec-cas01.example.org");
        System.out.println(str);
    }
}
