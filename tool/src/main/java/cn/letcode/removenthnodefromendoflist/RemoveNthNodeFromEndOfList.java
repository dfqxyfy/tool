package cn.letcode.removenthnodefromendoflist;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        ListNode l = new ListNode(0);
        l.next = head;
        temp = l;
        int cur = 0;
        int index = count - n;

        while (cur < index) {
            temp = temp.next;
            cur++;
        }
        if(temp.next!=null) {
            temp.next = temp.next.next;
        }else{
            temp.next = null;
        }
        return l.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}