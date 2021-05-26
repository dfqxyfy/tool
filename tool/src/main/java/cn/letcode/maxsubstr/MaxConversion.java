package cn.letcode.maxsubstr;

public class MaxConversion {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int totCol = s.length()/2+numRows-1;

        char chars[][] = new char[numRows][totCol];
        int row = 0;
        int col = 0;
        int group = 2*numRows - 2;
        boolean first0 = true;
        for(int i=0;i<s.length();i++){
            if(i%group<numRows){
                if(!first0) {
                    col++;
                    first0 = true;
                }
                chars[i%group][col] = s.charAt(i);
            }else if(i%group >= numRows){
                col++;
                chars[2*numRows-i%group-2][col]=s.charAt(i);
            }
            if(i%group==numRows-1){
                first0 = false;
            }
        }
        StringBuilder strb = new StringBuilder();
        for(int i=0;i<chars.length;i++){
            for(int j=0;j<chars[0].length;j++){
                if(chars[i][j] != 0) {
                    strb.append(chars[i][j]);
                }
            }
        }
        return strb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MaxConversion().convert("PAYPALISHIRING", 3));
        System.out.println(new MaxConversion().convert("PAYPALISHIRING", 4));
        System.out.println(new MaxConversion().convert("A", 1));
        System.out.println(new MaxConversion().convert("ABC", 2));
    }
}
