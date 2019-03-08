package cn.ccs.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

public class JNDIContainer {

    private Context ctx = null;

    public void init() throws Exception {
        //初始化JNDI提供者。
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        env.put(Context.PROVIDER_URL, "file:/soft/a"); //fscontext的初始目录，我们需要在c:\下创建sample目录。
        ctx = new InitialContext(env);
        loadServices();
    }

    //从配置文件JNDIContainer.properties中读取DBService和LogService实现，绑定到Context中。
    private void loadServices() throws Exception {
        InputStream in = getClass().getResourceAsStream("JNDIContainer.properties");
        Properties props = new Properties();
        props.load(in);

        //inject dbservice
        String s = props.getProperty("DBServiceClass");
        Object obj = Class.forName(s).newInstance();
        if (obj instanceof DBService) {
            DBService db = (DBService) obj;
            String[] ss = props.getProperty("DBServiceProperty").split(";");
            for (int i = 0; i < ss.length; i++)
                db.setProperty(i, ss[i]);
            ctx.rebind(props.getProperty("DBServiceName"), db);
        }

        //inject logservice
        s = props.getProperty("LogServiceClass");
        obj = Class.forName(s).newInstance();
        if (obj instanceof LogService) {
            LogService log = (LogService) obj;
            ctx.rebind(props.getProperty("LogServiceName"), log);
        }
    }

    public void close() throws NamingException {
        ctx.close();
    }

    public Context getContext() {
        return ctx;
    }
}