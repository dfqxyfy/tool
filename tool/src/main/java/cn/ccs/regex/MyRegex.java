package cn.ccs.regex;

public class MyRegex {
    public static void main(String[] args) {
        String str = "1234567".replaceAll("\\d(?=(\\d{3})+)",",");
        System.out.println(str);
    }
}
