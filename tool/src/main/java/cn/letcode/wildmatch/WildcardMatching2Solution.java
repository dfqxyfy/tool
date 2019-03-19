package cn.letcode.wildmatch;

import java.util.ArrayList;
import java.util.List;

public class WildcardMatching2Solution {

    public boolean isMatch(String s, String p) {
        List<Integer> posiList = new ArrayList<>();
        posiList.add(0);
        for (int i = 0; i < p.length(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (Integer pos : posiList) {
                if (p.charAt(i) == '*') {
                    for (int j = pos; j < s.length(); j++) {
                        temp.add(j);
                    }
                } else if (p.charAt(i) == '?') {
                    temp.add(pos + 1);
                } else if (pos < s.length() && p.charAt(i) == s.charAt(pos)) {
                    temp.add(pos + 1);
                }
            }
            posiList = temp;
            for(Integer c:temp){
                System.out.print(c+"\t");
            }
            System.out.println();
        }
        return posiList.contains(s.length());
    }

    public static void main(String[] args) {
        boolean b = new WildcardMatching2Solution().isMatch("abcd", "a*d");
        System.out.println(b);
    }
}
