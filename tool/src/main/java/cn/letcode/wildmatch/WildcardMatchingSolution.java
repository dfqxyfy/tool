package cn.letcode.wildmatch;

public class WildcardMatchingSolution {
    String pStr;
    String sStr;
    boolean isMatch = false;

    //动态规划
    public boolean isMatch(String s, String p) {
        this.sStr = s;
        this.pStr = p;
        find(0, 0);
        return isMatch;
    }

    public void find(int curIndex, int pIndex) {
        if (curIndex == sStr.length() && pIndex == pStr.length()) {
            isMatch = true;
            return;
        }
        if (curIndex > sStr.length() || pIndex > pStr.length()) {
            return;
        }
        for (int i = pIndex; i < pStr.length(); i++) {
            if (pStr.charAt(i) == '*') {
                for (int j = curIndex; j < sStr.length(); j++) {
                    find(j + 1, pIndex + 1);
                }
            } else if (pStr.charAt(i) == '?') {
                find(curIndex + 1, pIndex + 1);
            } else if (sStr.charAt(i) != pStr.charAt(i)) {
                return;
            } else if (sStr.charAt(i) == pStr.charAt(i)) {
                find(curIndex+1,pIndex+1);
            }

        }
    }


    public static void main(String[] args) {
        boolean b = new WildcardMatchingSolution().isMatch("abcd", "a*d");
        System.out.println(b);
    }
}
