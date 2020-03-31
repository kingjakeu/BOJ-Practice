package LEETCODE.medium.dfs;

public class Q98_ValidateBinarySearchTree {

    class Solution {
        boolean answer = true;
        int rootVal = 0;
        public boolean isValidBST(TreeNode root) {

            if(root != null){
                rootVal = root.val;
                dfs(root, root.val, rootVal);
            }
            return answer;
        }

        public void dfs(TreeNode node, int min, int max){
            searchLeft(node, min, max);
            searchRight(node, min, max);
        }

        public void searchLeft(TreeNode node, int min, int max){
            if(node.left != null){
                if(node.val <= node.left.val ||  min >= node.left.val || max <= node.left.val){
                    answer = false;
                    return;
                }
                dfs(node.left, min, max);
            }
        }

        public void searchRight(TreeNode node, int min, int max){
            if(node.right != null){
                if(node.val >= node.right.val || min >= node.right.val || max <= node.right.val){
                    answer = false;
                    return;
                }
                dfs(node.right, min, node.val);
            }
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
