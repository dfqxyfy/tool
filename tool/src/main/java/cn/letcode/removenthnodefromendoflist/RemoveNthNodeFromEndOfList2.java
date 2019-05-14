package cn.letcode.removenthnodefromendoflist;

public class RemoveNthNodeFromEndOfList2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // n+1        n       ...    1
        // (n+1)    target    ...   end    NULL
        //  1         2       ...  (n+1)'  NULL
        // step1 find (n+1) node, distance between end and (n+1) is n
        // step2 then (n+1).next = (n+1).next.next
        ListNode target = head, cur = head;
        // first iterate to find (n+1)' node from the beginning
        while (n-- > 0) {
            cur = cur.next;
        }
        // if (n+1)' node is NULL, which means (n+1) node is the pre node of the head,
        // we should remove the head, or do step1&2
        if (cur == null) {
            head = head.next;
        } else {
            while (cur.next != null) {
                cur = cur.next;
                target = target.next;
            }
            target.next = target.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new RemoveNthNodeFromEndOfList2().removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
