package cn.letcode;

public class RegularSolution {
    public boolean isMatch(String s, String p) {
        boolean matches = s.matches("^" + p + "$");
        return matches;
    }

    public static void main(String[] args) {
        String s="aaaa";
        String p="a*";
        System.out.println(new RegularSolution().isMatch(s,p));
    }
}
