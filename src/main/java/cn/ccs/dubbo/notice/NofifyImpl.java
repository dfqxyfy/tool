package cn.ccs.dubbo.notice;

/**
 * Created by chaichuanshi on 2017/5/16.
 */
public class NofifyImpl implements Nofify {
//    @Override
//    public void onreturn(Object msg, Integer id) {
//        System.out.println("onreturn:" + msg+" : "+id);
//    }

    @Override
    public void onreturn(Object msg, Object msg1) {
        System.out.println("onreturn:" + msg+" :" +msg1.getClass());
        System.out.println("onreturn:" + msg+" :" +msg1.toString());
    }

    @Override
    public void onthrow(Throwable ex, Integer id) {
        System.out.println("onthrow:" + id);
    }
}
