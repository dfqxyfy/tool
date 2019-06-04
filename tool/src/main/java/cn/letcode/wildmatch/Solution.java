package cn.letcode.wildmatch;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        if (s == null || p == null) return false;
        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();
        // matched[i][j]表示是否成功匹配到p的第i个（不含）和s的第j个（不含）
        boolean[][] matched = new boolean[pa.length + 1][sa.length + 1];
        matched[0][0] = true;
        for (int i = 1; i <= pa.length; i++) {
            matched[i][0] = pa[i - 1] == '*' && matched[i - 1][0];
            for (int j = 1; j <= sa.length; j++) {
                if (pa[i - 1] == '*')
                    matched[i][j] = matched[i][j - 1] || matched[i - 1][j];
                else if (pa[i - 1] == '?')
                    matched[i][j] = matched[i - 1][j - 1];
                else if (pa[i - 1] == sa[j - 1])
                    matched[i][j] = matched[i - 1][j - 1];
            }
        }
        return matched[pa.length][sa.length];
    }

    public static void main(String[] args) {
        boolean b = new Solution().isMatch("abcd", "a*d");
        System.out.println(b);
    }
}