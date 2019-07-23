package LEETCODE;

/**
 * Created by jakeu on 23/07/2019.
 */
public class Q83_RemoveDuplicatesfromSortedList {
}
class Q83_ListNode {
        int val;
        Q83_ListNode next;
        Q83_ListNode(int x) { val = x; }
 }
class Q83_RemoveDuplicatesfromSortedList_Solution {
    public Q83_ListNode deleteDuplicates(Q83_ListNode head) {
        Q83_ListNode node = head;

        while(node != null){
            Q83_ListNode nextNode = node.next;
            if(nextNode != null){
                if(node.val == nextNode.val){
                    nextNode = nextNode.next;
                    node.next = nextNode;
                }else{
                    node = node.next;
                }
            }else{
                break;
            }
        }
        return head;
    }
}