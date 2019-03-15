package cn.ccs.basictype;

import java.util.Arrays;

public class CharTest {


    public static void main(String[] args) {
        Character c = 'a';
        //System.out.println(c.toString());
        System.out.println(new StringBuilder(c).toString());
        new String();

        String strs = "eat";
        System.out.println(strs.toCharArray());
        char[] chars = strs.toCharArray();
        Arrays.sort(chars);
        System.out.println(new String(chars));
    }
}
