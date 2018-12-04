package cn.ccs.netty.selfprotocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by chaichuanshi on 2017/6/22.
 */
public class LuckClientHandler extends SimpleChannelInboundHandler<LuckMessage> {

//    @Override
//    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LuckMessage message) throws Exception {
//        System.out.println(message);
//    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, LuckMessage msg) throws Exception {
        System.out.println(msg);
    }
}