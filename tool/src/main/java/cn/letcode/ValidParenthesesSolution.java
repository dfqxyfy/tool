package cn.letcode;

import java.util.Stack;

public class ValidParenthesesSolution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            String s1 = Character.toString(s.charAt(i));
            if("(".equals(s1)||"{".equals(s1)||"[".equals(s1)){
                stack.push(s1);
            }else{
                if(stack.empty()){
                    return false;
                }
                String pop = stack.pop();
                if(")".equals(s1) && !"(".equals(pop)){
                        return false;
                }else if("}".equals(s1) && !"{".equals(pop)){
                        return false;
                }else if("]".equals(s1) && !"[".equals(pop)){
                        return false;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesesSolution().isValid("["));
    }
}
