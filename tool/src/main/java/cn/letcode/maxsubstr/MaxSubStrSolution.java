package cn.letcode.maxsubstr;

import java.util.HashMap;
import java.util.Map;

public class MaxSubStrSolution {

    public int maxLen(String s){
        Map<Character,Integer> map = new HashMap<>();
        int start = 0;
        int max =0;
        int tempLen = 0;
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) == null ){
                tempLen = i-start+1;
            }else if(map.get(s.charAt(i)) != null){
                if(map.get(s.charAt(i)) >= start){
                    start = map.get(s.charAt(i))+1 ;
                }else if(map.get(s.charAt(i)) < start){
                    tempLen = i-start+1;
                }
            }
            map.put(s.charAt(i),i);
            max = Math.max(tempLen,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubStrSolution().maxLen("abcabcbb"));
        System.out.println(new MaxSubStrSolution().maxLen("bbbbb"));
        System.out.println(new MaxSubStrSolution().maxLen("pwwkew"));
        System.out.println(new MaxSubStrSolution().maxLen("dvdf"));
        System.out.println(new MaxSubStrSolution().maxLen("abcbedcaba"));
        System.out.println("********");
        System.out.println(new MaxSubStrSolution().mm("abcabcbb"));
        System.out.println(new MaxSubStrSolution().mm("bbbbb"));
        System.out.println(new MaxSubStrSolution().mm("pwwkew"));
        System.out.println(new MaxSubStrSolution().mm("dvdf"));
        System.out.println(new MaxSubStrSolution().mm("abcbedcaba"));
    }

    public int mm(String s){

        if(s == ""){
            return 0;
        }
        int curLength = 0; // 记录以当前字符的上一个字符为结尾的最长不重复子字符串
        int maxLength = 0; // 记录最长不重复子串
        HashMap<Character,Integer> stringIndex = new HashMap<>(); // 字符出现的下标

        for(int i = 0;i<s.length();i++){
            if (stringIndex.containsKey(s.charAt(i))){
                // 如果该字符出现过
                int d = i - stringIndex.get(s.charAt(i)); // 计算当前字符与上一次出现时的距离
                if(d>curLength){
                    // 如果上一次出现的位置不在当前最长不重复的子串中
                    curLength++;
                } else {
                    // 如果在
                    curLength = d;
                }
            } else {
                // 如果当前字符没有出现过
                curLength ++;
            }
            if (curLength > maxLength){
                maxLength = curLength;
            }
            stringIndex.put(s.charAt(i),i);
        }
        return maxLength;
    }
}
