package cn.ccs.dubbo.remote.code;

import org.junit.Test;

/**
 * Created by chaichuanshi on 2017/6/21.
 */
public class DubboCodec {
    @Test
    public void testShort(){
        final short    MAGIC              = (short) 0xdabb;
        System.out.println(MAGIC);
        long x = 0xdabb;
        System.out.println(x);

        byte b1 = (byte) 0xda;
        byte b2 = (byte) 0xbb;
        System.out.println(b1);
        System.out.println(b2);
    }
}
