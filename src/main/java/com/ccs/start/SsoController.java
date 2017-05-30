package com.ccs.start;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by ccs on 2017/3/18.
 */
@Controller
public class SsoController {

    private final static String STAT_FINAL_STR = "temp_cookie";
    @Value("${abcd:3333333}")
    private String abcd;

    @ResponseBody
    @RequestMapping("/abcd")
    String home() {
        System.out.println(abcd);
        return "Hello World!";
    }
//    @RequestMapping("/a")
//    String a(HttpServletRequest request) {
//        String value = getCookie(request,STAT_FINAL_STR);
//        System.out.println("loging STAT_FINAL_STR ："+ value);
//        return "/a.html";
//    }
//
//    @RequestMapping("/aa")
//    String aa(HttpServletRequest request) {
//        String value = getCookie(request,STAT_FINAL_STR);
//        System.out.println("loging STAT_FINAL_STR ："+ value);
//        return "aa.html";
//    }
//
//    @RequestMapping("/b")
//    String b(HttpServletRequest request) {
//        String value = getCookie(request,STAT_FINAL_STR);
//        System.out.println("loging STAT_FINAL_STR ："+ value);
//        return "b.html";
//    }
//
//    @RequestMapping("/bb")
//    String bb(HttpServletRequest request) {
//        String value = getCookie(request,STAT_FINAL_STR);
//        System.out.println("loging STAT_FINAL_STR ："+ value);
//        return "bb.html";
//    }

    private String getCookie(HttpServletRequest request,String name){
        Cookie[] cookies = request.getCookies();
        System.out.println("cookie log...............");
        if(cookies !=null)
            for(Cookie cookie:cookies){
                System.out.println(JSON.toJSONString(cookie));
                if(name.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        System.out.println("cookie log...............end");
        return null;
    }

}
