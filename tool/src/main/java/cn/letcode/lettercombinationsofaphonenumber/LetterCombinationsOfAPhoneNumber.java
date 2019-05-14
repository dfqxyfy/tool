package cn.letcode.lettercombinationsofaphonenumber;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    Set<String> resultSet = new HashSet<>();
    List<Set<Character>> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return new ArrayList<>();
        }
        Map<Integer,Set<Character>> map = new HashMap<>();
        for(int i=2;i<=7;i++){
            Set<Character> set = new HashSet<>();
            for(int j=0;j<3;j++){
                set.add((char)('a'+j+(i-2)*3));
            }
            map.put(i,set);
        }
        for(int i=8;i<=9;i++){
            Set<Character> set = new HashSet<>();
            for(int j=0;j<3;j++){
                set.add((char)('t'+j+(i-8)*3));
            }
            map.put(i,set);
        }
        map.get(9).add('z');
        map.get(7).add('s');
        char[] chars = digits.toCharArray();
        Arrays.sort(chars);
        for(char c: chars){
            if(map.get(Integer.valueOf(c-'0'))!=null) {
                list.add(map.get(Integer.valueOf(c-'0')));
            }
        }
        createList(0,new StringBuilder());

        return new ArrayList<String>(resultSet);

    }

    private void createList(int cur,StringBuilder strb ){
        if(cur>=list.size()){
            resultSet.add(strb.toString());
            return;
        }
        Set<Character> characters = list.get(cur);
        for(int i = 0; i< characters.size(); i++){
            Iterator<Character> iterator = characters.iterator();
            while (iterator.hasNext()){
                StringBuilder strb2 = new StringBuilder(strb);
                strb2.append(iterator.next());
                createList(cur+1,strb2);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letter = new LetterCombinationsOfAPhoneNumber();
        List<String> strings = letter.letterCombinations("7");
        strings.forEach(s -> {
            System.out.print(s);
        });
        System.out.println();
    }
}
