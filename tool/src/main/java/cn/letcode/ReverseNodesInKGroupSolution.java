package cn.letcode;

public class ReverseNodesInKGroupSolution {

    public ListNode  reverseKGroup(ListNode head, int k) {

        ListNode resultNode = new ListNode(0);
        ListNode preNode = resultNode;

        while(head!=null && isEnough(head,k)){
            int l=k;
            ListNode tail=null;
            ListNode nextHead=null;
            while(l>0){
                nextHead=head.next;
                l--;
                if(tail==null){
                    tail=head;
                    tail.next=null;
                }
                ListNode preNext = preNode.next;
                preNode.next = head;
                head.next=preNext;
                head=nextHead;
            }
            preNode = tail;
        }
        preNode.next=head;
        return resultNode.next;
    }

    private boolean isEnough(ListNode head,int k){
        ListNode temp = head;
        for(int i=0;i<k;i++){
            if(temp == null)
                return false;
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNodeAAA = new ReverseNodesInKGroupSolution().reverseKGroup(listNode,2);
        while(listNodeAAA != null){
            System.out.print(listNodeAAA.val+"->");
            listNodeAAA=listNodeAAA.next;
        }
    }
}
