package cn.letcode;

public class SwapNodesInPairsSolution {
    public ListNode swapPairs(ListNode head) {

        if(head==null||head.next==null){
            return head;
        }
        ListNode resultNode = new ListNode(0);
        ListNode preNode = null;
        while(head!=null && head.next != null){
            if(resultNode.next==null){
                resultNode.next=head.next;
                preNode = resultNode;
            }
            ListNode nnext = head.next.next;
            preNode.next=head.next;
            preNode.next.next = head;
            preNode.next.next.next=nnext;

            preNode=head;

            head = nnext;
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNodeAAA = new SwapNodesInPairsSolution().swapPairs(listNode);
        while(listNodeAAA != null){
            System.out.print(listNodeAAA.val+"->");
            listNodeAAA=listNodeAAA.next;
        }
    }


}
