package cn.letcode.lengthoflastword;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int res=0;
        int temp=0;
        //s=s.trim();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                temp++;
                res=temp;
            }else{
                temp=0;
            }
        }
        return res;
    }
}
