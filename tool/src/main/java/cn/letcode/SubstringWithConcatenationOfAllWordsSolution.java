package cn.letcode;

import java.util.ArrayList;
import java.util.List;

public class SubstringWithConcatenationOfAllWordsSolution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList=new ArrayList<>();
        if(words==null||words.length==0){
            return resultList;
        }
        int len=words[0].length();
        for(int i=0;i<=s.length()-len;i++){
            List<String> wordsList = initList(words);
            for(int j=i;j<=s.length()-len;) {
                String temp = s.substring(j,j+len);
                if (wordsList.contains(temp)) {
                    j = j + len;
                    wordsList.remove(temp);
                } else{
                    break;
                }
            }
            if(wordsList.size()==0){
                resultList.add(i);
            }
        }
        return resultList;
    }
    private List<String>  initList(String[] words){
            List<String> wordsList = new ArrayList<>();
            for(int i=0;i<words.length;i++){
                wordsList.add(words[i]);
            }
            return wordsList;
    }

    public static void main(String[] args) {
        String res = "wordgoodgoodgoodbestword";
        String words[] = new String[]{"word","good","best","good"};
        //words = new String[]{"foo","bar"};
        //res = "barfoothefoobarman";
        words=new String[]{"a"};
        res = "a";
        List<Integer> barfoothefoobarman = new SubstringWithConcatenationOfAllWordsSolution().findSubstring(res, words);

        for(Integer i:barfoothefoobarman){
            System.out.println(i);
        }

        List<String> list = new SubstringWithConcatenationOfAllWordsSolution().initList(words);
        list.remove("good");
        list.forEach(s->{
            System.out.println(s);
        });


    }
}
