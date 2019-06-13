package cn.letcode.simplifypath;

import java.util.Stack;

public class SimplifyPathSolution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        String[] strs=path.split("/");
        for(String s:strs){
            if(s.equals("..")){
                if(stack.size()>0)
                    stack.pop();
            }else if(s.equals(".")){
            }else if(s!=null&&!"".equals(s)){
                stack.push(s);
            }
        }
        String resPath="";
        while (stack.size()>0){
            String pop = stack.pop();
            if(!"".equals(pop)) {
                resPath = "/" + pop + resPath;
            }
        }
        if("".equals(resPath)){
            resPath="/";
        }
        return resPath;
    }

    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        path = "/home/../../..";
        path="/a//b////c/d//././/..";
        String res=new SimplifyPathSolution().simplifyPath(path);
        System.out.println(res);
    }
}
