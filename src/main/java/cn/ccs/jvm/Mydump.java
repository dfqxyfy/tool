package cn.ccs.jvm;

import com.hdjf.common.pojo.thrid.sd.HttpClientUtil;
import org.jboss.marshalling.InputStreamByteInput;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mydump {
    public static void main(String[] args) {
        Integer a = 3;
        String s = "abc";
        System.out.println(a);
        System.out.println(s);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<1;i++){
            stringBuilder.append("abcdefg");
        }
        Ab ab = new Ab();
        List<Ab> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            ab.list.add(stringBuilder.toString());
            list.add(new Ab("112345"));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("a");
                    Ab ab1 = new Ab("332421");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
            try {
                Thread.sleep(3000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

class Ab{
    private String a;
    public List<String> list = new ArrayList<>();

    public Ab(){
    }
    public Ab(String a){
        this.a = a;
    }
}
