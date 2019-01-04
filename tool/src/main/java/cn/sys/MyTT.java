package cn.sys;

import cn.ccs.dubbo.extensionloader.MyInterface;
import org.json.JSONObject;

public class MyTT {



    public void aaa(JSONObject o){
        System.out.println(o.get("xxxx"));
    }

    public void bbb(JSONObject o){

    }

    public static void main(String[] args) {
        JSONObject o  = new JSONObject();
        o.put("xxxx","aaa");
        for(int i=0;i<2;i++){
            new ExThread(o).start();
        }
        System.out.println("******");
        System.out.println(o.get("xxxx"));
    }
}
class ExThread extends Thread{
    JSONObject myTT  ;
    public ExThread(JSONObject myTT){
        myTT=null;
        this.myTT = myTT;
    }
    @Override
    public void run(){
        System.out.println(myTT.get("xxxx"));
        myTT = new JSONObject();
        myTT.put("xxxx","fsadfsaf");
        System.out.println(myTT.get("xxxx"));
    }
}
