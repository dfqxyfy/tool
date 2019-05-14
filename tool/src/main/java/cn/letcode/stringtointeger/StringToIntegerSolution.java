package cn.letcode.stringtointeger;

public class StringToIntegerSolution {
    public int myAtoi(String str) {
        StringBuilder strb = new StringBuilder();

        boolean findNum=false;
        boolean positive=true;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if(findNum==false && str.charAt(i)==' '){
                continue;
            }else if(findNum==false && (c == '+' || c == '-')){
                if(c=='-'){
                    positive = false;
                }
                findNum=true;
            }else if( c >= '0' && c <= '9'){
                findNum=true;
                strb.append(c);
            }else{
                break;
            }
        }
        if(strb.length()==0){
            return 0;
        }
        String result=strb.toString();
        if(!positive){
            result = "-"+strb.toString();
        }
        try{
            return Integer.valueOf(result);
        }catch(Exception e){
            if(positive){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        //int i = new StringToIntegerSolution().myAtoi("   -42");
        //System.out.println(i);
        System.out.println(Integer.valueOf("123"));
        System.out.println(Integer.MIN_VALUE );
        System.out.println(Integer.MIN_VALUE -1);
        System.out.println(Integer.MIN_VALUE +1);
        System.out.println();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE-1);
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MAX_VALUE+2);

        System.out.println();
        System.out.println(Integer.MIN_VALUE-Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE+Integer.MAX_VALUE);
        System.out.println(-Integer.MIN_VALUE+Integer.MAX_VALUE);
    }

}
