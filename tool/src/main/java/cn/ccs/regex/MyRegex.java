package cn.ccs.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {
    public static void main(String[] args) {
        String str = "1234567".replaceAll("\\d(?=(\\d{3})+)",",");
        System.out.println(str);

        String rega = "^((?!Exception).)*$";
        Pattern pattern = Pattern.compile(rega);
        String s = "com.NullPointException:";
        String s2="fadsfas";

        Matcher matcher = pattern.matcher(s);
        boolean b = matcher.find();
        System.out.println(b);
        System.out.println(s.matches(rega));
        if(b){
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
        }

        Matcher matcher2 = pattern.matcher(s2);
        boolean b1 = matcher2.find();
        System.out.println(b1);
        System.out.println(s2.matches(rega));
        if(b1){
            System.out.println(matcher2.group());
            System.out.println(matcher2.group(1));
        }


        String reg = "^((?!Exception).)*$";
        System.out.println("com.NullPointException".matches(reg));
        System.out.println("com.NullPointExceptio2".matches(reg));
    }
}
