package cn.ccs.spring.resource.bean;

/**
 * Created by chaichuanshi on 2017/3/3.
 */
public class ReplaceBean implements ResourceInterface  {
    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
