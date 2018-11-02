package cn.ccs.concurrent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String reg = "/.*?!(\\.html$)";


        String reg2 = "^((?!\\.html$).)*$";

        reg2 = "\\w*(?!\\.html$)";
        reg2 = "\\w*[^(\\.html$)]";
        String str= "aaa.html";
        //str= "aaa.hl";
        //System.out.println(str.matches(reg));
        System.out.println(str.matches(reg2));

        reg2 = "(^[^\\.]+$)";
        System.out.println("/login".matches(reg2));
        Pattern p = Pattern.compile(reg2);
        Matcher matcher = p.matcher("/login");
        //boolean b = matcher.find();
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
