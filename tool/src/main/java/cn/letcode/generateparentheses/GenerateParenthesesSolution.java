package cn.letcode.generateparentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesSolution {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder strb = new StringBuilder();
        genString(strb, 0, 0, n);
        return list;
    }

    private void genString(StringBuilder strb, int left, int right, int n) {

        if (left == n && right == n) {
            list.add(strb.toString());
            return;
        }
        if (left > n || right > n || right > left) {
            return;
        }

        genString(new StringBuilder(strb).append("("), left+1, right, n);
        genString(new StringBuilder(strb).append(")"), left, right+1, n);
    }

    public static void main(String[] args) {
        List<String> strings = new GenerateParenthesesSolution().generateParenthesis(3);
        strings.forEach(s -> {
            System.out.println(s);
        });
    }
}
