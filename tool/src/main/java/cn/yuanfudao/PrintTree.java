package cn.yuanfudao;

import java.util.ArrayList;
import java.util.List;

public class PrintTree {

    List<List<Integer>> list = new ArrayList<>();


    public List<List<Integer>> genNode(Node root){
        List<Node> resList = new ArrayList<>();
        resList.add(root);
        print(1,resList);
        return list;
    }

    private void print(int dept,List<Node> resList){
        if(resList.size()==0){
            return;
        }else{
            List<Integer> iList=new ArrayList<>();
            if(dept%2==1){
                for(int i=resList.size()-1;i>=0;i--){
                    iList.add(resList.get(i).right.val);
                    iList.add(resList.get(i).left.val);
                }
            }else{
                for(int i=0;i<resList.size();i++){
                    iList.add(resList.get(i).left.val);
                    iList.add(resList.get(i).right.val);
                }
            }
        }
        List<Node> tempList = new ArrayList<>();

        for(int i=0;i<resList.size();i++){
                tempList.add(resList.get(i).left);
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
        int dept=0;
        while(dept>0){
        }
        return e;
    }

    public void initNode(int dept,List<Node> list){
        List<Node> templist=new ArrayList<>();

        for(int i=0;i<list.size();i++){

            Node node = new Node();
        }

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
