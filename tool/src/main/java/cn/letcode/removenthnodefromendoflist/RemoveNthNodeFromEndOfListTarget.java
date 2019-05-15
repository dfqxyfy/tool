package cn.letcode.removenthnodefromendoflist;

public class RemoveNthNodeFromEndOfListTarget {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        while(n>0){
            n--;
            node = node.next;
        }
        ListNode home = new ListNode(0);
        home.next=head;
        ListNode target = home;
        while(node!=null){
            target=target.next;
            node=node.next;
        }

        if(target.next!=null){
            target.next=target.next.next;
        }
        return home.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new RemoveNthNodeFromEndOfListTarget().removeNthFromEnd(head, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
