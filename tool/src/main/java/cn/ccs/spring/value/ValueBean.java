package cn.ccs.spring.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by chaichuanshi on 2017/2/22.
 */
@Component(value="valueBean")
public class ValueBean {

    @Value("${test.value}")
    private String value;
    @Value("#{propertyConfigurer['test.name']}")
    private String name;

    @PostConstruct
    public void aa(){
        System.out.println("***************************************");
        System.out.println(value);
        System.out.println(name);
        System.out.println("***************************************");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
