package cn.ccs.log;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
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
    }


}
