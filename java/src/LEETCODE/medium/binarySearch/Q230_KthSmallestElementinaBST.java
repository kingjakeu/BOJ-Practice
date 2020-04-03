package LEETCODE.medium.binarySearch;

import java.util.regex.Pattern;

public class Q230_KthSmallestElementinaBST {

    class Solution {
        int count = 1;
        int answer = 0;
        public int kthSmallest(TreeNode root, int k) {
            search(root, k);
            return answer;
        }
        public void search(TreeNode node, int k){
            if(node.left != null) search(node.left, k);
            if(count++ == k) answer = node.val;
            if(node.right != null) search(node.right, k);
        }
    }
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }


    }
}
