package cn.ccs.dubbo.notice;

import java.io.Serializable;

/**
 * Created by chaichuanshi on 2017/5/16.
 */
public class Person implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
