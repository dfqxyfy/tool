package cn.ccs.demo.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyComp {

    @Autowired
    private IA ia;
    @PostConstruct
    public void aaa(){
        ia.aaa();
    }
}
