package cn.ccs.dubbo.transporter;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.ChannelHandler;
import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.transport.AbstractServer;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CcsServer extends AbstractServer {

    private static ServerSocket serverSocket = null;

    private URL url;
    private ChannelHandler handler;

    private List<Channel> channels = new ArrayList<Channel>();

    public CcsServer(URL url, ChannelHandler handler) throws RemotingException {
        super(url, handler);
        this.url = url;
        this.handler = handler;
        channels.add(new CcsChannel(url, handler));
    }

    @Override
    protected void doOpen() throws Throwable {
        if(serverSocket == null){
            serverSocket = new ServerSocket(12345);
        }
    }

    @Override
    protected void doClose() throws Throwable {
        serverSocket.close();
    }

    @Override
    public boolean isBound() {
        return true;
    }

    @Override
    public Collection<Channel> getChannels() {
        return channels;
    }

    @Override
    public Channel getChannel(InetSocketAddress remoteAddress) {
        return channels.get(0);
    }
}
