package cn.letcode.multiplystrings;

public class MultiplyStringsSolution {

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
                strb=new StringBuilder(add(strb.toString(),temp.toString()));
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

    private String add(String str1, String str2) {
        StringBuilder strb=new StringBuilder();
        int len1= str1.length()-1;
        int len2= str2.length()-1;
        int flag=0;
        while(len1>=0||len2>=0){
            int sum=0;
            if(len1>=0) {
                sum += (str1.charAt(len1)-'0');
                len1--;
            }
            if(len2>=0) {
                sum += (str2.charAt(len2)-'0');
                len2--;
            }
            if(flag>0) {
                sum += flag;
            }
            flag=sum/10;
            sum=sum%10;
            strb.append(sum);
        }
        if(flag==1){
            strb.append(1);
        }
        return strb.reverse().toString();
    }

    public static void main(String[] args) {
        MultiplyStringsSolution solution = new MultiplyStringsSolution();
        String add = solution.add("1234", "8").toString();
        System.out.println(add);

        String multiply = solution.multiply("123", "456");
        System.out.println(multiply);
    }
}
