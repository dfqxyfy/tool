package cn.letcode.my;

//import java.util.EmptyStackException;
import java.util.Stack;

public class LeftSolution {
    public int numCount(String str){
        char[] arr = new char[str.length()];
        int count = 0;
        int index = 0;
        for(char c:str.toCharArray()){
            if(c=='('){
                arr[index]='(';
                index++;
                count++;
            }else{
                index--;
                if(index<0){
                    return -1;
                }
            }
        }
        if(index==0) {
            return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "()";
        int i = new LeftSolution().numCount(str);
        System.out.println(i);
    }
}
