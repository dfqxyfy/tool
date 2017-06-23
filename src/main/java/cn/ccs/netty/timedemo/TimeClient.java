package cn.ccs.netty.timedemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {

    private ChannelFuture channelFuture;

    public static void main(String[] args) throws Exception {
        int port = 9000;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {
            }
        }


        final TimeClient timeClient = new TimeClient();
        new Thread(() -> {
            for (int i = 0; ; i++) {
                final int count = i;
                new Thread(() -> {
                    if (timeClient.channelFuture != null) {
                        System.out.println("threading..." + count);
                        final ByteBuf firstMessage;
                        byte[] req = ("QUERY TIME ORDER <<aa>>" + count).getBytes();
                        firstMessage = Unpooled.buffer(req.length);
                        firstMessage.writeBytes(req);
                        timeClient.channelFuture.channel().writeAndFlush(firstMessage);

                    }
                }).start();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        timeClient.connect(port, "127.0.0.1");

    }

    public void connect(int port, String host) throws Exception {
        // 配置客户端NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel arg0)
                                throws Exception {
                            System.out.println("client initChannel..");
                            arg0.pipeline().addLast(new TimeClientHandler());
                        }
                    });

            // 发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();
            this.channelFuture = f;
            // 等待客户端链路关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放NIO线程组
            group.shutdownGracefully();
        }
    }
}