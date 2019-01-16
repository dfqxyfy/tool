package cn.letcode;

public class MergekSortedListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultList = null;
        ListNode header = null;
        ListNode temp = null;
        while((temp=findMin(lists))!=null){
            if(resultList == null) {
                header = temp;
                resultList = temp;
            }else {
                resultList.next = temp;
                resultList = resultList.next;
            }
        }
        return header;
    }

    private ListNode findMin(ListNode[] lists){
        ListNode minNode = null;
        int min = 0;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null && (minNode == null || minNode.val > lists[i].val)){
                minNode = lists[i];
                min = i;
            }
        }
        ListNode resultNode = minNode;
        if(min<lists.length && lists[min]!=null)
            lists[min] = lists[min].next;
        return resultNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode lists[] = new ListNode[]{listNode,
                listNode2,listNode3
                };

        ListNode resList = new MergekSortedListsSolution().mergeKLists(lists);
        while(resList != null){
            System.out.print(resList.val);
            if(resList.next!=null){
                System.out.print("->");
            }
            resList = resList.next;
        }
    }
}
