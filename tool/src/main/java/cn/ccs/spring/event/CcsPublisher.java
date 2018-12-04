package cn.ccs.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by chaichuanshi on 2017/5/10.
 */
@Component
public class CcsPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void pub(ApplicationEvent applicationEvent){
        applicationEventPublisher.publishEvent(applicationEvent);
    }
}
