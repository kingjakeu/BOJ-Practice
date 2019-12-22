package LEETCODE;

public class Q104_MaximumDepthofBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution {
        public int find(TreeNode node){
            if (node == null) return 0;
            int l = 0, r = 0;
            if(node.left != null){
                l = find(node.left);
            }
            if(node.right != null){
                r = find(node.right);
            }
            return Math.max(1+l,1+r);
        }
        public int maxDepth(TreeNode root) {
            int answer = 0;
            if(root == null) return answer;

            answer = find(root);
            return answer;
        }
    }
}
