package cn.ccs.dubbo.transporter;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.*;

public class CcsTransporter implements Transporter {
    @Override
    public Server bind(URL url, ChannelHandler handler) throws RemotingException {
        Server server = new CcsServer(url,handler);
        return server;
    }

    @Override
    public Client connect(URL url, ChannelHandler handler) throws RemotingException {
        Client client = new CcsClient(url,handler);
        return client;
    }
}
