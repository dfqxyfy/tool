package cn.ccs.netty.selfprotocol;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by chaichuanshi on 2017/6/22.
 */
public class LuckClientInitializer extends ChannelInitializer<SocketChannel> {

    private static final LuckEncoder ENCODER = new LuckEncoder();

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        ChannelPipeline pipeline = channel.pipeline();

        // 添加编解码器, 由于ByteToMessageDecoder的子类无法使用@Sharable注解,
        // 这里必须给每个Handler都添加一个独立的Decoder.
        pipeline.addLast(ENCODER);
        pipeline.addLast(new LuckDecoder());

        // and then business logic.
        pipeline.addLast(new LuckClientHandler());

    }
}