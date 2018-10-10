package cn.ccs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class WebAppliction {
    public static void main(String[] args) {
        SpringApplication.run(WebAppliction.class,args);
    }
}
