package cn.letcode;

import java.util.ArrayList;
import java.util.List;

public class BruteSolution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c ){
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c)) {
                        System.out.println(c);
                        ans.add("(" + left + ")" + right);
                    }

            }
        }
        return ans;
    }



    public static void main(String[] args) {
        List<String> strings = new BruteSolution().generateParenthesis(3);
        for(String s:strings){
            System.out.println(s);
        }
    }
}
