package cn.ccs.dubbo.transporter;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.ChannelHandler;
import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.transport.AbstractClient;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CcsClient extends AbstractClient {

    private Socket socket = null;

    private Channel channel = null;

    public CcsClient(URL url, ChannelHandler handler) throws RemotingException {
        super(url, handler);
        channel = new CcsChannel(url,handler);
    }

    @Override
    protected void doOpen() throws Throwable {
        if(socket == null)
            socket = new Socket(this.getUrl().getHost(),this.getUrl().getPort());

    }

    @Override
    protected void doClose() throws Throwable {
        if(socket != null )
            socket.close();
    }

    @Override
    protected void doConnect() throws Throwable {

    }

    @Override
    protected void doDisConnect() throws Throwable {

    }

    @Override
    protected Channel getChannel() {
        return channel;
    }

}