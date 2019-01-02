package cn.letcode;

public class LengthSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        String sMax = "";
        for(int i=0;i<s.length();i++){
            String sTemp = "";
            for(int j=i+1;j<=s.length();j++){
                if(sTemp == null || sTemp.indexOf(s.charAt(j-1)) == -1){
                    sTemp = s.substring(i, j);
                    if(sMax == null){
                        sMax=sTemp;
                    }
                    if(sTemp.length() > sMax.length()) {
                        sMax = sTemp;
                    }
                }else{
                    break;
                }
            }
        }
        return sMax.length();
    }

    public static void main(String[] args) {
        String s=" ";

        LengthSubstringSolution lengthSubstringSolution = new LengthSubstringSolution();
        System.out.println(lengthSubstringSolution.lengthOfLongestSubstring(s));
    }
}
