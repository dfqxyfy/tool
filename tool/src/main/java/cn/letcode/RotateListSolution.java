package cn.letcode;

public class RotateListSolution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode tail = head;
        while (tail != null) {
            tail = tail.next;
            len++;
        }
        int remove = len - k % len;
        if (remove % len == 0) {
            return head;
        }

        ListNode preNode = null;
        ListNode headtl = head;

        while (remove > 0) {
            remove--;
            preNode = head;
            head = head.next;
        }
        if (preNode != null)
            preNode.next = null;

        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = headtl;

        return head;
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
//        ln.next.next=new ListNode(3);
//        ln.next.next.next=new ListNode(4);
//        ln.next.next.next.next=new ListNode(5);

        RotateListSolution rs = new RotateListSolution();
        ListNode listNode = rs.rotateRight(ln, 2);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }

    }
}



