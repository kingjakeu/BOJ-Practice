package LEETCODE;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q61_RotateList {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Q61_RotateList_Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tempNode = head;
        int size = 0;
        if(k == 0){
            return head;
        }
        while(tempNode!=null){
            tempNode = tempNode.next;
            size += 1;
        }
        if(size <= 1){
            return head;
        }
        k = k%size;
        tempNode = head;
        ListNode newNode = new ListNode(0);
        ListNode newhead = newNode;
        for (int i = 0; i < size-k; i++) {
            newNode.next = new ListNode(tempNode.val);
            newNode = newNode.next;
            tempNode = tempNode.next;
        }
        head = tempNode;
        while(tempNode.next!=null){
            tempNode = tempNode.next;
        }
        tempNode.next = newhead.next;
        return head;
    }
}