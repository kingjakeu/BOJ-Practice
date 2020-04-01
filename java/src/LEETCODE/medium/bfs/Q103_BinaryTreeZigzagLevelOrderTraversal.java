package LEETCODE.medium.bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q103_BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> answer = new LinkedList<>();
            if(root == null) return answer;
            int listSize = 0;
            Deque<Dot> que = new LinkedList<>();
            que.add(new Dot(root, 0, false));
            Deque<Dot> newQue = new LinkedList<>();
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
                if(dot.lefty){
                    if(dot.node.right != null){
                        newQue.addFirst(new Dot(dot.node.right, dot.depth+1, false));
                    }
                    if(dot.node.left != null){
                        newQue.addFirst(new Dot(dot.node.left, dot.depth+1, false));
                    }
                }else{
                    if(dot.node.left != null){
                        newQue.addFirst(new Dot(dot.node.left, dot.depth+1, true));
                    }
                    if(dot.node.right != null){
                        newQue.addFirst(new Dot(dot.node.right, dot.depth+1, true));
                    }
                }
                if(que.isEmpty()){
                    que = newQue;
                    newQue = new LinkedList<>();
                }
            }
            return answer;
        }
    }
    class Dot{
        TreeNode node;
        int depth;
        boolean lefty;
        Dot(TreeNode node, int depth, boolean lefty){
            this.node = node;
            this.depth = depth;
            this.lefty = lefty;
        }
    }
}
