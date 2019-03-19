package cn.letcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WildcardMatchingSolution {
    public boolean isMatch(String s, String p) {
        Set<Integer> positions = new HashSet<>();
        positions.add(0);
        for (int i = 0; i < p.length(); i++) {
            Set<Integer> nexts = new HashSet<>();
            Iterator<Integer> it = positions.iterator();
            while (it.hasNext()) {
                Integer pos = it.next();
                if (p.charAt(i) == '*') {
                    for (int j = pos; j <= s.length(); j++) {
                        nexts.add(j);
                    }
                } else if (p.charAt(i) == '?') {
                    nexts.add(pos + 1);
                } else {
                    if (pos < s.length() && s.charAt(pos) == p.charAt(i)) {
                        nexts.add(pos + 1);
                    }
                }
            }
            positions = nexts;
//            System.out.print(i +"  ");
//            for(Integer j:nexts){
//                System.out.print(j);
//            }
//            System.out.println();
        }

        return positions.contains(s.length());
    }


    public static void main(String[] args) {
        String s = "aaab";
        String p = "a*b";
//        s = "aa";
//        p = "a";
        boolean b = new WildcardMatchingSolution().isMatch(s, p);
        System.out.println(b);
    }

    public boolean simple(String s, String p) {
        Pattern pattern = Pattern.compile("^" + p.replaceAll("\\?", ".?").replaceAll("\\*", ".*") + "$");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }
}
