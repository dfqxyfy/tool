package cn.letcode;

public class TestABC {
    public static void main(String[] args) {
        String s = "ABC";
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= c.length; i++) {
            permutation(c, 0, i, sb);
        }

        permutation("abc");
    }

    private static void permutation(char[] c, int begin, int len, StringBuffer sb) {
        if (len == 0) {                //当都选择结束时打印sb内容
            System.out.println(sb + " ");
            return;
        }

        if (begin == c.length)
            return;

        sb.append(c[begin]);                //取
        permutation(c, begin + 1, len - 1, sb);    //剩下的里面选len-1个
        sb.deleteCharAt(sb.length() - 1);    //不取
        permutation(c, begin + 1, len, sb);    //剩下的里面选len个

    }


    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

}