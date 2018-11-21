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


        String s = "start<a>xxxx</a> middlecontent <a>cccc</a>end";
        String regex2 = "<a>.*?</a>";
        String regex3 = "<a>.*</a>";
        String s1 = s.replaceAll(regex2, "");
        String s2 = s.replaceAll(regex3, "");
        System.out.println(s1);
        System.out.println(s2);


        String st = "(</?)((div)|(body))(>)";
        String st2 = "<div>afdsafdsaf</div><body>aaaa</body>";
        String regex22 = "[div,body]+";
        System.out.println(st.matches(regex22));
        System.out.println(st2.matches(regex22));

        System.out.println(st2.replaceAll(st,"$1"));

    }
}
