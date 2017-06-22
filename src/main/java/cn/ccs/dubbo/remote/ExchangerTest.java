package cn.ccs.dubbo.remote;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.logger.Level;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.exchange.*;
import com.alibaba.dubbo.remoting.exchange.support.Replier;
import org.junit.Test;

/**
 * Created by chaichuanshi on 2017/6/20.
 */
public class ExchangerTest {
    private static final Logger logger;

    static {
        LoggerFactory.setLevel(Level.ERROR);
        logger = LoggerFactory.getLogger(ExchangerTest.class);
    }

    URL serverURL = URL.valueOf("header://localhost:55555");
    @Test
    public void testServer() throws Exception {
        serverURL = serverURL.addParameter(Constants.HEARTBEAT_KEY, 1000);
        ExchangeServer server = Exchangers.bind(serverURL, new MyExchangeHandler(){
            public void sent(Channel channel, Object message) throws RemotingException {
                System.out.println("SERVER:: SENT..... "+message);
                //received(channel,"[server deal..<<<<"+message+">>>> ]");
            }
            public void received(Channel channel, Object message) throws RemotingException {
                System.out.println("SERVER:: RECEIVED..... "+message);
                logger.error(this.getClass().getSimpleName() + message.toString());
            }
        }, new MyReplier());
        System.out.println("Server bind successfully");
        Thread.sleep(300000);

    }
    @Test
    public void testClient() throws Exception{
        final ExchangeClient client = Exchangers.connect(serverURL, new MyExchangeHandler() {
            public void sent(Channel channel, Object message) throws RemotingException {
                System.out.println("CLIENT:: sent..... " + message);
            }

            public void received(Channel channel, Object message) throws RemotingException {
                System.out.println("CLIENT:: received..... " + message);
                System.out.println(this.getClass().getSimpleName() + message.toString());
            }
        });
        //ResponseFuture requString = client.request("[client send .. requString");
        for( int i = 0; i< 1; i++) {
            final int count = i;
            new Thread() {
                @Override
                public void run() {
                    try {
                        ResponseFuture requString = client.request(">>>[client] send msg " +  (count+1) + " times<<<");
                        Object obj = requString.get();
                        System.out.println("\t\t---" + obj);
                        //client.getExchangeHandler().received(client.getChannelHandler().);
                    } catch (RemotingException e) {
                    }
                }
            }.start();
        }
        Thread.sleep(300000);
        client.close();
    }


}

class MyReplier implements Replier<Object>{

    @Override
    public Object reply(ExchangeChannel channel, Object request) throws RemotingException {
        System.out.println("MyReplier:"+request);
        return request;
    }
}

class MyExchangeHandler implements ExchangeHandler {
    public int disconnectCount = 0;
    public int connectCount = 0;

    public Object reply(ExchangeChannel channel, Object request) throws RemotingException {
        System.out.println("reply:"+request);
        return request;
    }

    public void connected(Channel channel) throws RemotingException {
        ++connectCount;
    }

    public void disconnected(Channel channel) throws RemotingException {
        ++disconnectCount;
    }

    public void sent(Channel channel, Object message) throws RemotingException {
        //received(channel,"server deal..");
        System.out.println("sent.......");
    }

    public void received(Channel channel, Object message) throws RemotingException {
        System.out.println(this.getClass().getSimpleName() + message.toString());
    }

    public void caught(Channel channel, Throwable exception) throws RemotingException {
        exception.printStackTrace();
    }

    public String telnet(Channel channel, String message) throws RemotingException {
        System.out.println("CLIENT:: telnet... "+message);
        return message;
    }
}