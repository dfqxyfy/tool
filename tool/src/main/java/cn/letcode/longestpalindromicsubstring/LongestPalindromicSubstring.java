package cn.letcode.longestpalindromicsubstring;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String palind = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            for (int j = 0; i - j >= 0 && i + j+1 <= s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    temp = s.substring(i - j, i + j + 1);
                    if (temp.length() > palind.length()) {
                        palind = temp;
                    }
                } else {
                    break;
                }
            }
            if (i + 1 < s.length()) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    for (int j = 0; i - j >= 0 && i + j + 2 <= s.length(); j++) {
                        if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                            temp = s.substring(i - j, i + j + 2);
                            if (temp.length() > palind.length()) {
                                palind = temp;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return palind;
    }

    public static void main(String[] args) {
        String s = "a";
//        System.out.println(s.substring(1,2));
//        System.out.println(s.substring(0,3));
        String s1 = new LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(s1);
//        System.out.println();
//        System.out.println();
//        System.out.println(s.charAt(0));
//        System.out.println(s.charAt(1));
//        System.out.println(s.charAt(2));
//        System.out.println(s.charAt(3));
//        System.out.println(s.substring(1, 3));
//        System.out.println(s.substring(0, 4));
    }
}
