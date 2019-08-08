package LEETCODE;

public class Q25_ReverseNodesinkGroup {
}
class Q25ListNode {
     int val;
    Q25ListNode next;
    Q25ListNode(int x) { val = x; }
}
class Q25_ReverseNodesinkGroup_Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = head;
        ListNode node = head;
        while(node != null){
            int[] valList = new int[k];
            for (int i = 0; i < k; i++) {
                valList[i] = node.val;
                node = node.next;
                if(node == null){
                    return newHead;
                }
            }
            for (int i = k-1; i >= 0; i--) {
                newHead.val = valList[i];
                newHead = newHead.next;
            }
        }
        return newHead;
    }
}