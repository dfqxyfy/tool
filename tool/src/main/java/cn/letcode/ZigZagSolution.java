package cn.letcode;

public class ZigZagSolution {
    public String convert(String s, int numRows) {
        if("".equals(s)||s==null){
            return "";
        }
        if(numRows == 1){
            return s;
        }
        int totCol =(s.length()/(numRows+numRows-2) + 1)* (numRows-1);
        char tempArr[][] = new char[numRows][totCol];
        System.out.println(numRows+" "+totCol);
        int row = 0 ;
        int col = 0;
        //增加行
        boolean addRow=true;
        //增加列
        boolean addCol=false;
        for(int k=0;k<s.length();k++){
            System.out.println("row="+row+" col="+col);
            tempArr[row][col] = s.charAt(k);

            if((row+1)>=numRows && addCol==false){
                addRow=false;
                addCol=true;
            }else if((row-1)<0 && addRow == false){
                addRow=true;
                addCol=false;
            }

            if(addRow){
                row++;
            }else{
                row--;
            }
            if(addCol){
                col++;
            }else{
                col=col;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
//        System.out.println("*****");
//        System.out.println(tempArr.length);
//        System.out.println(tempArr[0].length);
//        System.out.println("*****");
        for(int i=0;i<tempArr.length;i++){
            for(int j=0;j<tempArr[i].length;j++){
                if(tempArr[i][j]==0){
                    System.out.print("-");
                }else {
                    stringBuilder.append(tempArr[i][j]);
                    System.out.print(tempArr[i][j]+"");
                }
            }
            System.out.println();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        /**
         "kprcfbdpdkurgnbffjjpmhrbfnuywpfgfwimzlbcvvudlxisguiudzwknqkliprpnbbpoermcnpnmahvuppzrljeewronkdblg"
         81
         */
        String paypal = new ZigZagSolution().convert("kprcfbdpdkurgnbffjjpmhrbfnuywpfgfwimzlbcvvudlxisguiudzwknqkliprpnbbpoermcnpnmahvuppzrljeewronkdblg", 81);
        //String paypal = new ZigZagSolution().convert("abcdeabcde1", 4);
        System.out.println(paypal);
    }
}
