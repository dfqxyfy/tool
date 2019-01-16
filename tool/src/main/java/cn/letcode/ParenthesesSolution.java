package cn.letcode;

import java.util.List;

public class ParenthesesSolution {
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;

        StringBuilder stringBuilder = new StringBuilder();

        String ss[] = new String[2*n];
        for(int i=0;i<ss.length;i++){
            if(i>3){
                ss[i]=")";
            }else {
                ss[i]="(";
            }
        }
        for(int i=0;i<ss.length;i++){
            for(int j=0;j<right;j++){
                stringBuilder.append("(");
            }
        }
        return null;
    }
}
