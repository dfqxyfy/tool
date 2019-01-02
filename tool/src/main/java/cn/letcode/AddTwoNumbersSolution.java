package cn.letcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbersSolution {
    ListNode result = null;
    ListNode tail = null;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        addLink(l1,l2,0);
        return result;
    }

    void addLink(ListNode l1,ListNode l2,int flag){
        if(flag == 0&&l1 == null && l2 ==null){
            return;
        }
        ListNode node = new ListNode(0);
        ListNode lnode = null;
        ListNode rnode = null;
        if(l1 != null){
            node.val +=l1.val;
            lnode = l1.next;
        }
        if(l2 != null){
            node.val +=l2.val;
            rnode = l2.next;
        }
        node.val += flag;
        flag = node.val/10;
        node.val=node.val%10;
        if(result==null){
            result = node;
        }else{
            tail.next=node;
        }
        tail = node;
        addLink(lnode,rnode,flag);
    }


    public static void main(String[] args) {
        AddTwoNumbersSolution solution = new AddTwoNumbersSolution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = solution.addTwoNumbers(l1, l2);
        do{
            System.out.println(listNode.val);
            listNode=listNode.next;
        }while(listNode!=null);
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

