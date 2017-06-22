package cn.ccs.netty.nettyprotocol;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.ScheduledFuture;

import java.util.concurrent.TimeUnit;
  
public class HeartBeatReqHandler extends  ChannelHandlerAdapter{  
  
    private volatile ScheduledFuture<?> heartBeat;  
      
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg)  
            throws Exception {  
        NettyMessage message = (NettyMessage)msg;  
        if (message.getHeader() != null && message.getHeader().getType() == 4) {  
            heartBeat = ctx.executor().scheduleAtFixedRate(new HeartBeatReqHandler.HeartBeatTask(ctx), 0, 5000, TimeUnit.MILLISECONDS);  
        } else if (message.getHeader() != null && message.getHeader().getType() == 6) {  
            System.out.println("client receive server heart message : " + message);  
        } else {  
            ctx.fireChannelRead(msg);  
        }  
    }  
      
    private class HeartBeatTask implements Runnable {  
          
        private final ChannelHandlerContext ctx;  
          
        public HeartBeatTask(final ChannelHandlerContext ctx) {  
            this.ctx = ctx;  
        }  
  
        @Override  
        public void run() {  
            NettyMessage message = buildHeatBeat();  
            System.out.println("client send heart message :　" + message);  
            ctx.writeAndFlush(message);  
        }  
          
        private NettyMessage buildHeatBeat() {  
            NettyMessage message = new NettyMessage();  
            Header header = new Header();  
            header.setType((byte)5); //心跳请求消息  
            message.setHeader(header);  
            return message;  
        }  
    }  
      
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)  
            throws Exception {  
        if (heartBeat != null) {  
            heartBeat.cancel(true);  
            heartBeat = null;  
        }  
        ctx.fireExceptionCaught(cause);  
    }  
      
}  