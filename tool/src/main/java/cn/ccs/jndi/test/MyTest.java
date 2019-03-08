package cn.ccs.jndi.test;

import org.apache.commons.dbcp.BasicDataSource;

import javax.naming.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Hashtable;

public class MyTest {
//    public static void main(String[] args) {
//        Context ctx = null;
//        try {
//            Hashtable env = new Hashtable<>();
//            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.FSContextFactory");
//            env.put(Context.PROVIDER_URL, "file:/ccs/jndi");
//            ctx = new InitialContext(env);
//            TestObj obj = new TestObj();
//            ctx.bind(obj,"abcd");
//
//            Object abcd = ctx.lookup(obj);
//            ((TestObj)abcd).geta();
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try {
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.fscontext.RefFSContextFactory");
            System.setProperty(Context.PROVIDER_URL, "file:/ccs/jndi");
            InitialContext ic = new InitialContext();

            // Construct BasicDataSource
            BasicDataSource bds = new BasicDataSource();
            bds.setDriverClassName("org.apache.commons.dbcp2.TesterDriver");
            bds.setUrl("jdbc:apache:commons:testdriver");
            bds.setUsername("username");
            bds.setPassword("password");

            ic.rebind("jdbc/basic", new CcsRef("cn.ccs.jndi.test.TestObj"));


            // Use
            InitialContext ic2 = new InitialContext();
            Reference ds = (Reference) ic2.lookup("jdbc/basic");

            Enumeration<RefAddr> all = ds.getAll();
            System.out.println(ds.getClassName());;

            Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class CcsRef extends Reference {


    public CcsRef(String className) {
        super(className);
    }
    public void testPlus(){
        String a="aa";
        String b="bb";
        String ab = a+b;
    }
}