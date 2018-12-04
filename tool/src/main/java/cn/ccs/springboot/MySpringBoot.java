package cn.ccs.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.WeakHashMap;

/**
 * Created by chaichuanshi on 2017/1/12.
 */

@EnableAutoConfiguration
//@Configuration
@ComponentScan("cn.ccs.springboot")
//@ImportResource(value = {"classpath:generatorConfig.xml"})
@Controller
public class MySpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBoot.class, args);
    }



    @RequestMapping("/ab")
    public String mm(String name ,String value){
        System.out.println("........................");
        System.out.println(name +" : "+ value);
        System.out.println("........................");

        //Map<String,Object> map = new Hash
        new java.util.HashMap<>();
        return name;
    }
    @RequestMapping("/api/server/addr")
    public String http(HttpServletRequest request, HttpServletResponse response){

        return "asfdsfs";
    }
    @RequestMapping("/*")
    public String aaa(HttpServletRequest request, HttpServletResponse response){

        return "asfdsfs";
    }

}
