package cn.ccs.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by chaichuanshi on 2017/5/10.
 */
public class CcsApplicationEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CcsApplicationEvent(Object source) {
        super(source);
    }

    public String eventTest(){
        return "eventTest";
    }
}
