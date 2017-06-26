package cn.ccs.dubbo.remote.code;

import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.buffer.ChannelBuffer;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboCodec;
import org.junit.Test;

/**
 * Created by chaichuanshi on 2017/6/21.
 */
public class DubboCodecTest {
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

    @Test
    public void encode(){
        DubboCodec dubboCodec = new DubboCodec();
        Channel channel ;
        ChannelBuffer buffer;
        Object msg;
        dubboCodec.encode(channel,buffer,msg);
    }
}
