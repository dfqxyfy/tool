package cn.letcode.addtwosum;

public class AddTwoSumSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node=null;
        ListNode tailNode=null;
        boolean flag=false;
        while(l1!=null||l2!=null){
            int result=0;
            if(l1!=null){
                result+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                result+=l2.val;
                l2=l2.next;
            }
            if(flag){
                result+=1;
            }
            if(result/10>0){
                flag=true;
            }else{
                flag=false;
            }
            ListNode temp = new ListNode(result%10);
            if(node==null){
                node=temp;
            }else{
                tailNode.next=temp;
            }
            tailNode=temp;
        }
        if(flag){
            tailNode.next = new ListNode(1);
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(8);
        ListNode l2 = new ListNode(0);
        ListNode listNode = new AddTwoSumSolution().addTwoNumbers(l1, l2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
