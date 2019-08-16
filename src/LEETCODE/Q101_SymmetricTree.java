package LEETCODE;

public class Q101_SymmetricTree {
}

class Q101_TreeNode {
  int val;
  Q101_TreeNode left;
  Q101_TreeNode right;
  Q101_TreeNode(int x) { val = x; }
}
class Q101_SymmetricTree_Solution {
    public boolean checkit(Q101_TreeNode left, Q101_TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left!=null&&right!=null&&left.val == right.val){
            return checkit(left.left, right.right) && checkit(left.right, right.left);
        }
        return false;
    }
    public boolean isSymmetric(Q101_TreeNode root) {
        if(root == null) return true;
        return checkit(root.left, root.right);
    }
}