package cn.letcode.restoreipaddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddressesSolution {
    List<String> resList=new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        getAllIps(s,0,"");
        return resList;
    }
    public void getAllIps(String left,int index,String req){
        if(index==3){
            if((left.length()>1&&left.startsWith("0"))||left.length()>3||Integer.valueOf(left)>255){
                return;
            }else{
                resList.add(req+"."+left);
                return;
            }
        }
        for(int i=1;i<=3;i++){
            if(i>left.length()){
                break;
            }
            String substring1 = left.substring(0, i);
            if((substring1.length()>1&&substring1.startsWith("0"))||substring1.length()>3||Integer.valueOf(substring1)>255){
                break;
            }
            String substring = left.substring(i);
            if(substring.length()>0)
                getAllIps(substring,index+1,req+(req.equals("")?"":".")+left.substring(0,i));
        }
    }


    public static void main(String[] args) {
        String s = "25525511135";
        s="0000";
        //s="0279245587303";
        List<String> strings = new RestoreIPAddressesSolution().restoreIpAddresses(s);
        strings.forEach(st->{
            System.out.println(st);
        });
    }
}
