package cn.ccs.netty.timedemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

import java.util.Date;

public class TimeServerHandler extends ChannelHandlerAdapter {

    private int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
            System.out.println(++counter);
//        //System.out.println("server channelRead:"+msg);
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
//        body = new String(req, "UTF-8").substring(0, req.length - System.getProperty("line.separator").length());
//        System.out.println("The time server receive order:" + body);
//        String currentTime = body.startsWith("QUERY TIME ORDER") ? new Date(
//                System.currentTimeMillis()).toString() : "BAD ORDER";
//        currentTime = currentTime +System.getProperty("line.separator");
//        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
//        ctx.writeAndFlush(resp);

        String body = (String)msg;
        System.out.println("The time server receive order:" + body);
        String currentTime = body.startsWith("QUERY TIME ORDER") ? new Date(
                System.currentTimeMillis()).toString() : "BAD ORDER";
        currentTime = currentTime +System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        System.out.println("flush");
        super.flush(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channelReadComplete..");
        ctx.flush();//刷新后才将数据发出到SocketChannel
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.out.println("server exceptionCaught..");
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(msg);
        super.write(ctx, msg, promise);
    }
}