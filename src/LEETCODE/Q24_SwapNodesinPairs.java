package LEETCODE;

public class Q24_SwapNodesinPairs {
}

class Q24_ListNode {
    int val;
    Q24_ListNode next;
    Q24_ListNode(int x) { val = x; }
}
class Q24_SwapNodesinPairs_Solution {
    public Q24_ListNode swapPairs(Q24_ListNode head) {
        Q24_ListNode preNode = null;
        Q24_ListNode point = head;
        while (point != null){
            Q24_ListNode node = point;
            if(node.next!=null){
                Q24_ListNode postNode = new Q24_ListNode(node.next.val);
                node.next = node.next.next;
                postNode.next = node;
                if(preNode!=null){
                    preNode.next = postNode;
                }else{
                    head = postNode;
                }
                preNode = node;
                point = node.next;
            }else{
                point = point.next;
            }
            Q24_ListNode tmp = head;
            while (tmp!=null){

                tmp = tmp.next;
            }
        }
        return head;
    }
}