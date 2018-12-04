package cn.ccs.spring.childparent;

/**
 * Created by chaichuanshi on 2017/4/11.
 */
public class TestBean {
    private String beanName ;
    public TestBean(Object beanName){
        this.beanName = beanName == null?"":beanName.toString();
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "beanName='" + beanName + '\'' +
                '}';
    }
}
