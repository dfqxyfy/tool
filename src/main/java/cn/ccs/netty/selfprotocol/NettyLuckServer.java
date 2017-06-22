package cn.ccs.netty.selfprotocol;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

/**
 * Created by chaichuanshi on 2017/6/22.
 */
public class NettyLuckServer {

    // 指定端口号
    private static final int PORT = 8888;

    public static void main(String args[]) throws InterruptedException {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 指定socket的一些属性
            serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)  // 指定是一个NIO连接通道
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new NettyLuckInitializer());

            // 绑定对应的端口号,并启动开始监听端口上的连接
            Channel ch = serverBootstrap.bind(new InetSocketAddress("127.0.0.1",PORT)).sync().channel();

            System.out.printf("luck协议启动地址：127.0.0.1:%d/\n", PORT);

            Thread.sleep(10000);
            //jdk.internal.misc.Unsafe un;
            jdk.internal.cmm.SystemResourcePressureImpl j;
            // 等待关闭,同步端口
            ch.close();//.sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}