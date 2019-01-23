package cn.letcode;

public class LongestValidParenthesesSolution {
    public int longestValidParentheses(String s) {

        int max=0;
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else {
                right++;
            }
            if(right==left){
                if(max<right){
                    max=right;
                }
            }else if(right>left){
                left=right=0;
            }
        }
        left = right = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(right==left){
                if(max<right){
                    max=right;
                }
            }else if(left>right){
                left=right=0;
            }
        }

        return max*2;
    }

    public static void main(String[] args) {
        String s=")(((((()())()()))()(()))(";
//        s=")()())";
//        s="()(()";
//        s="(";
//        s=")()())()()(";
//        s="(()(";
//        s="))))((()((";
//        s="()((";
        s="(()";
        //s="(())()(()((";
        System.out.println(new LongestValidParenthesesSolution().longestValidParentheses(s));
    }
}
