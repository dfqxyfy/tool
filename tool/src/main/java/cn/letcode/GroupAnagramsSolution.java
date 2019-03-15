package cn.letcode;

import java.util.*;

public class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> resMap= new HashMap<>();
        for(String s:strs){
            String s1 = sortString(s);
            if(resMap.get(s1)==null){
                List<String> innerList = new ArrayList<>();
                innerList.add(s);
                resMap.put(s1,innerList);
            }else{
                resMap.get(s1).add(s);
            }
        }
        List<List<String>> resList = new ArrayList<>();
        for(List<String> l:resMap.values()){
            resList.add(l);
        }
        return resList;
    }
    private String sortString(String s){
        List<Character> list = new ArrayList<>();
        for(char c:s.toCharArray()){
            list.add(c);
        }
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(o1.charValue()>o2.charValue()){
                    return 1;
                }
                return -1;
            }
        });
        //System.out.println(list);
        StringBuilder stringBuilder = new StringBuilder();
        for(Character c:list){
            stringBuilder.append(c.toString());
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strs=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagramsSolution().groupAnagrams(strs);
        for(int i=0;i<lists.size();i++){
            for(int j=0;j<lists.get(i).size();j++){
                System.out.print(lists.get(i).get(j));
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
