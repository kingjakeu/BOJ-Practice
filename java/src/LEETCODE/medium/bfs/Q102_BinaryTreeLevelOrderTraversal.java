package LEETCODE.medium.bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102_BinaryTreeLevelOrderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> answer = new LinkedList<>();
            if(root == null) return answer;
            int listSize = 0;
            Queue<Dot> que = new LinkedList<>();
            que.add(new Dot(root, 0));

            while (!que.isEmpty()){
                Dot dot = que.poll();
                List<Integer> list;
                if(dot.depth == listSize){
                    list = new LinkedList<>();
                    answer.add(list);
                    listSize++;
                }else{
                    list = answer.get(dot.depth);
                }
                list.add(dot.node.val);
                if(dot.node.left != null){
                    que.add(new Dot(dot.node.left, dot.depth+1));
                }
                if(dot.node.right != null){
                    que.add(new Dot(dot.node.right, dot.depth+1));
                }
            }
            return answer;
        }
    }
    class Dot{
        TreeNode node;
        int depth;
        Dot(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}
