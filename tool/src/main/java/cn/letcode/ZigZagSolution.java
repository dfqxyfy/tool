package cn.letcode;

public class ZigZagSolution {
    public String convert(String s, int numRows) {
        int totalCol = s.length()/((numRows+1)/2);
//        if(s.length()%(numRows+1)%numRows == 0){
//            totalCol -= 1;
//        }
        if(s.length()%((numRows+1)/2)  > 0){
            totalCol = totalCol + 1;
        }
        char result[][] = new char[numRows][totalCol];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            //选出  i 该放在第几行，第几列
            //第几行
            int row = 0;
            int col = 0;

            int bascol = i/(numRows+1);

            if((i%(numRows+1)/numRows ) == 0){
                row = i%(numRows+1)%numRows;
                col = 2*bascol;
            }else{
                row = numRows/2;
                col = 2*bascol +  1;
            }

            result[row][col] = c;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i< result.length;i++){
            for(int j=0;j<result[i].length;j++){
                System.out.print(result[i][j]+"\t");
                if(result[i][j] ==  0){
                    stringBuilder.append(new String("-"));
                }else {
                    stringBuilder.append(Character.toString(result[i][j]));
                }
            }
            System.out.println();
            stringBuilder.append("\r\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String paypal = new ZigZagSolution().convert("paypal3223412141", 3);
        System.out.println(paypal);
    }
}
