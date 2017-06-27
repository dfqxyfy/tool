package cn.ccs.netty.nettyprotocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 该demo是netty权威上的
 */
public class NettyClient {

    EventLoopGroup group = new NioEventLoopGroup();
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        int port = 8080;
        new NettyClient().connect(port, "127.0.0.1");

    }

    private static ChannelFuture channelFuture;

    public void connect(final int port, final String host) {
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024, 4, 4, -8, 0));
                            ch.pipeline().addLast("MessageEncoder", new NettyMessageEncoder());
                            //ch.pipeline().addLast("readTimeoutHandler", new ReadTimeoutHandler(50));
                            //ch.pipeline().addLast("LoginAuthHandler", new LoginAuthReqHandler());
                            //ch.pipeline().addLast("HeartBeatHandler", new HeartBeatReqHandler());
                        }

                    });
            final ChannelFuture f = b.connect(host, port).sync();
            channelFuture = f;

            new Thread(){
                @Override public void run(){
                    while(true){
                        Header header = new Header();
                        header.setType((byte)6);  //心跳应答消息
                        //header.setLength(100);

                        NettyMessage message = new NettyMessage();
                        message.setHeader(header);
                        message.setBody("abcdef");
                        //message.setBody("");
                        System.out.println("writing.........");
                        f.channel().writeAndFlush(message);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println("error");
                            e.printStackTrace();
                        }
                    }};
            }.start();
            System.out.println("aaaaaaaa");
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        connect(port, host);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}  