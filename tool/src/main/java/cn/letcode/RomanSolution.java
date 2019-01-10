package cn.letcode;

public class RomanSolution {
    private StringBuilder strb = new StringBuilder();

    public String intToRoman(int num) {
        do {
            num = deal(num);
        } while (num > 0);

        return strb.toString();
    }

    private int deal(int num) {
        if (num >= 1000) {
            for (int i = 0; i < num / 1000; i++) {
                strb.append("M");
            }
            num = num % 1000;
        }
        if (num >= 100 && num < 1000) {
            if (num >= 900) {
                strb.append("CM");
                num = num % 1000;
            } else if (num >= 500 && num < 900) {
                strb.append("D");
                for (int i = 0; i < (num - 500) / 100; i++) {
                    strb.append("C");
                }
            } else if (num >= 400 && num < 500) {
                strb.append("CD");
            } else if (num >= 100 && num < 400) {
                strb.append("C");
                for (int i = 0; i < (num - 100) / 100; i++) {
                    strb.append("C");
                }
            }
            num = num % 100;
        }
        if (num >= 10 && num < 100) {
            if (num >= 90 && num < 100) {
                strb.append("XC");
            } else if (num >= 50 && num < 90) {
                strb.append("L");
                for (int i = 0; i < (num - 50) / 10; i++) {
                    strb.append("X");
                }
            } else if (num >= 40 && num < 50) {
                strb.append("XL");
            } else if (num >= 10 && num < 40) {
                strb.append("X");
                for (int i = 0; i < (num - 10) / 10; i++) {
                    strb.append("X");
                }
            }
            num = num % 10;
        }
        if (num > 0 && num < 10) {
            if (num >= 9 && num < 10) {
                strb.append("IX");
            } else if (num >= 5 && num < 9) {
                strb.append("V");
                for (int i = 0; i < (num - 5); i++) {
                    strb.append("I");
                }
            } else if (num >= 4 && num < 5) {
                strb.append("IV");
            } else if (num >= 1 && num < 4) {
                strb.append("I");
                for (int i = 0; i < (num - 1) / 1; i++) {
                    strb.append("I");
                }
            }
            num = num%1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new RomanSolution().intToRoman(58));
    }

}
