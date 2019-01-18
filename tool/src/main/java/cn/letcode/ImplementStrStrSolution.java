package cn.letcode;

public class ImplementStrStrSolution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        for(int i=0;i<haystack.length();i++){
            boolean exist = true;
            for(int j=0;j<needle.length();j++){
                if((i+j)>=haystack.length()||haystack.charAt(i+j)!=needle.charAt(j)){
                    exist=false;
                    break;
                }
            }
            if(exist) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementStrStrSolution().strStr("aa","aaa"));
    }
}
