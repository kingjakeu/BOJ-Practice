package LEETCODE;

public class Q19_RemoveNthNodeFromEndofList {
}

/**
 * Definition for singly-linked list.
 */
 class Q19_ListNode {
    int val;
    Q19_ListNode next;
    Q19_ListNode(int x) { val = x; }
 }
class Q19_RemoveNthNodeFromEndofList_Solution {
    public Q19_ListNode removeNthFromEnd(Q19_ListNode head, int n) {
        int count = 0;
        Q19_ListNode tempNode = head;
        while(tempNode != null){
            count++;
            tempNode = tempNode.next;
        }

        tempNode = head;
        Q19_ListNode preNode = null;
        for(int i =0; i<count-n; i++){
            preNode = tempNode;
            tempNode = tempNode.next;
        }
        if(preNode == null){
            head = tempNode.next;
        }else{
            preNode.next = tempNode.next;
        }
        return head;
    }
}
