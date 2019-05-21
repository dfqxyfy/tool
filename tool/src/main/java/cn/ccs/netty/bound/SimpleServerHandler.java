package cn.ccs.netty.bound;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

public class SimpleServerHandler extends ChannelDuplexHandler {

    @Override
    public void channelRead(ChannelHandlerContext ctx, final Object msg) throws Exception {
        ctx.channel().writeAndFlush(ByteBufAllocator.DEFAULT.buffer().writeBytes("OK".getBytes())).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----- INACTIVE -----");
        super.channelInactive(ctx);
    }

    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise future) throws Exception {
        System.out.println("----- CLOSE -----");
        super.close(ctx, future);
    }
}