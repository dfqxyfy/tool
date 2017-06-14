package cn.ccs.dubbo.notice;

/**
 * Created by chaichuanshi on 2017/5/16.
 */
public interface Nofify {
    public void onreturn(Object msg, Object msg1);
    public void onthrow(Throwable ex, Integer id);
}
