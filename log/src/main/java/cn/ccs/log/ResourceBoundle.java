package cn.ccs.log;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceBoundle {

    public static void main(String[] args) throws UnsupportedEncodingException {


        Locale currentLocale = Locale.CHINA;
        currentLocale = Locale.GERMAN;
        currentLocale = Locale.JAPAN;
        //ResourceBundle myResources = ResourceBundle.getBundle("MyResources", currentLocale);
        ResourceBundle myResources = ResourceBundle.getBundle("MyResources");

        System.out.println(new String(myResources.getString("key").getBytes("ISO-8859-1"),"utf-8"));
        final Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        allStackTraces.forEach((k,v)->{
            System.out.println(k);
            for(StackTraceElement stack:v){
                System.out.println(stack);
            }
            System.out.println("*******************");
        });
        try {
            while(true){
                Thread.sleep(100000);
                continue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
