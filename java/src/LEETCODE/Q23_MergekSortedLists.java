package LEETCODE;

import java.util.ArrayList;
import java.util.Collections;

public class Q23_MergekSortedLists {
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
class Q23_MergekSortedLists_Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(Integer.MIN_VALUE);
        int leng = lists.length;
        ListNode head = ans;
        while(true){
            ListNode minNode = new ListNode(Integer.MAX_VALUE);
            int idx = -1;
            for(int i=0; i<leng; i++){
                if(lists[i] != null){
                    if(lists[i].val<=minNode.val){
                        minNode = lists[i];
                        idx = i;
                    }
                }
            }
            System.out.println(minNode.val);
            if(idx >= 0){
                ans.next = minNode;
                ans = ans.next;
                lists[idx] = lists[idx].next;
            }else{
                break;
            }
        }
        ans = head.next;
        return ans;
    }
}