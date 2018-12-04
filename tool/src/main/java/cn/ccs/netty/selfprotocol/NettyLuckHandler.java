package cn.ccs.netty.selfprotocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by chaichuanshi on 2017/6/22.
 */
public class NettyLuckHandler extends SimpleChannelInboundHandler<LuckMessage> {
    //@Override
    protected void channelRead0(ChannelHandlerContext ctx, LuckMessage msg) throws Exception {
        // 简单地打印出server接收到的消息
        System.out.println(msg.toString());
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, LuckMessage msg) throws Exception {
// 简单地打印出server接收到的消息
        System.out.println(msg.toString());
    }
}