package cn.yuanfudao;

import java.util.ArrayList;
import java.util.List;

public class PrintTree {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> genNode(Node root){
        List<Node> resList = new ArrayList<>();
        resList.add(root);
        print(0,resList);
        return list;
    }

    private void print(int dept,List<Node> resList){
        if(resList.size()==0){
            return;
        }else{
            List<Integer> iList=new ArrayList<>();
            if(dept%2==1){
                for(int i=resList.size()-1;i>=0;i--){
                    iList.add(resList.get(i).val);
                }
            }else{
                for(int i=0;i<resList.size();i++){
                    iList.add(resList.get(i).val);
                }
            }
            list.add(iList);
        }
        List<Node> tempList = new ArrayList<>();

        for(int i=0;i<resList.size();i++){
            if(resList.get(i).left!=null)
                tempList.add(resList.get(i).left);
            if(resList.get(i).right!=null)
                tempList.add(resList.get(i).right);
        }
        print(dept+1,tempList);
    }

    public static void main(String[] args) {
        Node node = initNode();
        List<List<Integer>> lists = new PrintTree().genNode(node);
        System.out.println(lists);
    }


    private static Node initNode(){
        int[] all=new int[]{1,2,3,4,5,6,7};
        List<Node> list= new ArrayList<>();
        Node e = new Node(all[0]);
        list.add(e);
        int i=1;
        while(list.size()>0){
            List<Node> tempList=new ArrayList<>();
            for(int j=0;j<list.size();j++){
                if(i<all.length) {
                    Node node = list.get(j).left = new Node(all[i]);
                    tempList.add(node);
                    i++;
                }
                if(i<all.length) {
                    Node node = list.get(j).right = new Node(all[i]);
                    tempList.add(node);
                    i++;
                }
            }
            list=tempList;
        }
        return e;
    }


}
class Node{
    Node(int val){
        this.val=val;
    }
    int val;
    Node left;
    Node right;
}
