package cn.letcode.decodeways;

import java.util.ArrayList;
import java.util.List;

public class DecodeWaysSolution {
    int count = 0;
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        decoding(chars);
        return count;
    }

    public void decoding(char[] chars){
        if(chars==null||chars.length==0){
            count++;
            return;
        }
        if(chars.length>=1) {
            if(chars[0]>'0'){
                char[] tempchars=new char[chars.length-1];
                System.arraycopy(chars,1,tempchars,0,chars.length-1);
                decoding(tempchars);
            }else{
                return;
            }
        }
        if(chars.length>=2){
            if(chars[0] <= '0' || chars[0] > '2' || (chars[0]=='2' && chars[1] >'6')){
                return;
            }else{
                char[] tempchars=new char[chars.length-2];
                System.arraycopy(chars,2,tempchars,0,chars.length-2);
                decoding(tempchars);
            }
        }
    }

    public static void main(String[] args) {
        int i = new DecodeWaysSolution().numDecodings("27");
        System.out.println(i);
    }
}
