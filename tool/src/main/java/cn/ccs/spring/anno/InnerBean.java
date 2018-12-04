package cn.ccs.spring.anno;

import cn.ccs.spring.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chaichuanshi on 2016/10/28.
 */
@Component("innerBean")
public class InnerBean {
    @Autowired
    private cn.ccs.spring.Processor processor;

    public InnerBean(){
        System.out.println("innerBean init");
    }

    public void sss(){
        processor.proc();
    }

    public static void main(String[] args) {
        org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer preferencesPlaceholderConfigurer;

    }
}
