package cn.letcode;

public class CountAndSaySolution {
    public String countAndSay(int n) {
        String str = "1";
        for(int i=1;i<n;i++){

            str =  count(str);
        }
        return str;
    }

    private String count(String str){
        StringBuilder strb = new StringBuilder();

        for(int i=0;i<str.length();){
            int sum=1;
            char val = str.charAt(i);
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(j)==val){
                    sum++;
                }else{
                    break;
                }
            }
            i+=sum;
            strb.append(sum+""+val);
        }
        return strb.toString();
    }



    public static void main(String[] args) {
        String s = new CountAndSaySolution().countAndSay(3);
        String s2 = new CountAndSaySolution().countAndSay(6);
        System.out.println(s);
        System.out.println(s2);
    }

}
