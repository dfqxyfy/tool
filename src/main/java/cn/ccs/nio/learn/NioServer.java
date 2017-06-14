package cn.ccs.nio.learn;

import cn.ccs.nio.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Created by chaichuanshi on 2017/5/31.
 */
public class NioServer {

    private Selector selector;

    public void open() throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.socket().bind(new InetSocketAddress(10000));
        this.selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws Exception {
        while (true) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                if (next.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.write(ByteBuffer.wrap(new String("abcd").getBytes()));
                    socketChannel.register(this.selector, SelectionKey.OP_READ);
                }else {
                    read(next);
                }
            }
        }
    }

    public void read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel)key.channel();
        channel.configureBlocking(true);
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        channel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));

    }
}
