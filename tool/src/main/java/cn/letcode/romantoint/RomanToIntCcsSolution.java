package cn.letcode.romantoint;

public class RomanToIntCcsSolution {
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

    public int romanToInt(String s) {
        char pre = ' ';
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i>0) {
                pre = s.charAt(i-1);
            }
            n += val(pre, s.charAt(i));
        }
        return n;
    }

    int val(char prefix, char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return prefix == 'I' ? 3 : 5;
            case 'X':
                return prefix == 'I' ? 8 : 10;
            case 'L':
                return prefix == 'X' ? 30 : 50;
            case 'C':
                return prefix == 'X' ? 80 : 100;
            case 'D':
                return prefix == 'C' ? 300 : 500;
            case 'M':
                return prefix == 'C' ? 800 : 1000;
        }
        return 1;

    }

    public static void main(String[] args) {
        System.out.println(new RomanToIntCcsSolution().romanToInt("IX"));
    }

}
