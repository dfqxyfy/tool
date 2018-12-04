package cn.ccs.netty.nettyprotocol;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by chaichuanshi on 2017/6/26.
 */
public class CcsStringHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        //NettyMessage message = (NettyMessage)msg;
        System.out.println(msg.getClass());
        System.out.println("CcsStringHandler --> " + msg);
       // NettyMessage heartBeat = buildHeartBeat();
        //ctx.writeAndFlush(heartBeat);
        ctx.fireChannelRead(msg);
    }

    public NettyMessage buildHeartBeat() {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType((byte)6);  //心跳应答消息
        message.setHeader(header);

        message.setBody("server ....");
        return message;
    }
}
