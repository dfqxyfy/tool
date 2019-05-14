package cn.letcode.longestcommonprefix;

public class LongestCommonPrefixSolution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder strb=new StringBuilder("");
        if(strs==null||strs.length==0){
            return strb.toString();
        }
        int len = strs[0].length();
        for(int i=0;i<len;i++){
            char compair = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<i || !(compair==strs[j].charAt(i))){
                    return strb.toString();
                }
            }
            strb.append(compair);

        }
        return strb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        LongestCommonPrefixSolution longestCommonPrefixSolution = new LongestCommonPrefixSolution();
        String s = longestCommonPrefixSolution.longestCommonPrefix(strs);
        System.out.println(s);


        String a = "-11111111";
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.valueOf(a));
    }
}
