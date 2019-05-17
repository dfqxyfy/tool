package cn.letcode.longestvalidparentheses;

import java.util.Stack;

public class LongestValidParenthesesStackSolution {

    public int longestValidParentheses(String s) {
        int max=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }else {
                    max = Math.max(i - stack.peek(), max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "()";
        long l1 = System.currentTimeMillis();
        int i = new LongestValidParenthesesStackSolution().longestValidParentheses(s);
        long l2 = System.currentTimeMillis();
        System.out.println(i);
        //System.out.println(l2 - l1);
    }

}
