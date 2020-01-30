package cn.letcode.multiplystrings;

public class MultiplySolution {

    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int m1 = Character.getNumericValue(num1.charAt(i));
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int m2 = Character.getNumericValue(num2.charAt(j));
                int result = res[i + j + 1] + m1 * m2 + carry;
                carry = result / 10;
                res[i + j + 1] = result % 10;
            }
            int len = 0;
            while (carry > 0) {
                res[i - len] += carry;
                carry = res[i - len] / 10;
                res[i - len ] %= 10;
                len++;
            }
        }
        StringBuilder strb = new StringBuilder();
        boolean prex0=true;
        for (int i = 0; i < res.length; i++) {
            if(prex0==true && res[i]==0){
            }else{
                prex0=false;
                strb.append(res[i]);
            }
        }
        if(strb.length()==0){
            return "0";
        }
        return strb.toString();
    }

    public static void main(String[] args) {
        MultiplySolution multiplySolution = new MultiplySolution();
        String multiply = multiplySolution.multiply("55", "55");
        System.out.println(multiply);
    }
}
