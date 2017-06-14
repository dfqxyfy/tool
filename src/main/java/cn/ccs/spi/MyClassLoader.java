package cn.ccs.spi;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by chaichuanshi on 2017/5/15.
 */
public class MyClassLoader {

    public static void main(String[] args) throws IOException {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        //Enumeration<URL> urls = cl.getResources("D:\\prom\\zkcluster\\zookeeper-3.5.1-alpha-2\\bin");
        //Enumeration<URL> urls = cl.getResources("E:\\intelliJGit\\tools\\tools\\src\\main\\resources\\application.properties");
        Enumeration<URL> urls = cl.getResources("spring");
        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println("url:"+url.getPath());
        }
    }

}
