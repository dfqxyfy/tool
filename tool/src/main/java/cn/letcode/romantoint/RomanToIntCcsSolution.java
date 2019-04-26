package cn.letcode.romantoint;

public class RomanToIntCcsSolution {
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

    public int romanToInt(String s){
        //String[] allTypes=new String[]{"CM","MCCC","MCC","MC","CD","DCCC","DCC","DC","MI","","",};
        char pre = ' ';
        for(int i=0;i<s.length();i++) {
            s.charAt(i);
            return 1;
        }
        return 1;
    }

    int val(char prefix,char c){
        switch(prefix) {
            case 'I':
                return 1;
            case 'V':
                return prefix == 'I' ? 3 : 5;
            case 'X':
                return prefix == 'I' ? 7 : 9;
            //case
        }
        return 1;

    }

}
