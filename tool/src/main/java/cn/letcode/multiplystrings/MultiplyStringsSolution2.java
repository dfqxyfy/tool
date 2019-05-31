package cn.letcode.multiplystrings;

public class MultiplyStringsSolution2 {

    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        StringBuilder strb = new StringBuilder("0");
        for (int i = chars1.length - 1; i >= 0; i--) {
            for (int j = chars2.length - 1; j >= 0; j--) {
                StringBuilder temp = new StringBuilder(""+(chars1[i]-'0')*(chars2[j]-'0'));
                for(int k=0;k<chars1.length-1-i;k++){
                    temp.append("0");
                }
                for(int k=0;k<chars2.length-1-j;k++){
                    temp.append("0");
                }
                strb=new StringBuilder();
            }
        }
        int index=0;
        for(int i=0;i<strb.length();i++){
            if(strb.charAt(i)!='0'){
                break;
            }else{
                index=i;
            }
        }
        String result=strb.substring(index);
        if(strb.length()==0){
            return "0";
        }
        return result;
    }

    public static void main(String[] args) {
        MultiplyStringsSolution2 solution = new MultiplyStringsSolution2();

        String multiply = solution.multiply("123", "456");
        System.out.println(multiply);
    }
}
