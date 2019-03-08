package cn.ccs.demo.comp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfi {
    @Bean
    @ConditionalOnMissingBean(IA.class)
    public IA getIA(){
        return new IA(){
            @Override
            public void aaa() {
                System.out.println("IA......");
            }
        };
    }


    @Bean
    @ConditionalOnMissingBean(IA.class)
    public IA getIAB(){
        return new IA(){
            @Override
            public void aaa() {
                System.out.println("IBBBBBBBBBB......");
            }
        };
    }
}
