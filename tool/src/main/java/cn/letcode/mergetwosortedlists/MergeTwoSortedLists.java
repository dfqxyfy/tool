package cn.letcode.mergetwosortedlists;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode l = temp;
        while (l1 != null || l2 != null) {
            if (l1!=null && (l2 == null || (l1!=null && l1.val < l2.val) ) ) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return l.next;
    }

    public static void main(String[] args) {
        ListNode l1 = null;;
        ListNode l2 = new ListNode(0);
        ListNode listNode = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
        while (listNode!=null){
            System.out.print(listNode.val +" -> ");
            listNode=listNode.next;
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