package cn.ccs.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by chaichuanshi on 2017/5/10.
 */
@Component
public class CcsApplicationListener2 implements ApplicationListener<CcsApplicationEvent> {
    @Override
    public void onApplicationEvent(CcsApplicationEvent event) {
        System.out.println("ccsApplicationEvent2 dealing....."+event.eventTest());
    }
}
