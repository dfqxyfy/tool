package cn.letcode.removenthnodefromendoflist;

public class RemoveNthNodeFromEndOfListTest {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        int index = len - n;
        node = head;
        if (index == 0) {
            return node.next;
        } else {
            while ( --index > 0) {
                node = node.next;
            }
            if (node.next != null) {
                node.next = node.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new RemoveNthNodeFromEndOfListTest().removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
