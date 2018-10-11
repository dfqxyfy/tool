package cn.ccs.spring.duplicatebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Caller {
    @Autowired
    private DubProcessor dubProcessor;

    @Resource(name = "methodProc")
    private DubProcessor dubProcessor2;


    public void invoke(){
        int count = dubProcessor.getCount();
        System.out.println(dubProcessor.getStr());
        System.out.println(dubProcessor2.getStr());
    }
}
