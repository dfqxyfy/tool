package cn.ccs.netty.bound;

import io.netty.channel.*;

class SimpleDuplex2 extends ChannelHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("---- write 2 ----");
        super.write(ctx, msg, promise);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("---- read 2 ----");
        super.channelRead(ctx, msg);
    }
}