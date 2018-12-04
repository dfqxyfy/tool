package cn.ccs.spring.anno;

/**
 * Created by chaichuanshi on 2016/10/28.
 */
public class FactoryBean {
    public FactoryBean(){
        System.out.println("controller.........");
    }

    public void create(){
        System.out.printf("create");
    }
}
