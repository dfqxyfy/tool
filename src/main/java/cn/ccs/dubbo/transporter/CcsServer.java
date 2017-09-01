package cn.ccs.dubbo.transporter;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.ChannelHandler;
import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.transport.AbstractServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CcsServer extends AbstractServer {

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

    }

    @Override
    protected void doClose() throws Throwable {

    }

    @Override
    public boolean isBound() {
        return false;
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
