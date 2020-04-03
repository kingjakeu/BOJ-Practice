package LEETCODE.medium.binarySearch;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q378_KthSmallestElementinaSortedMatrix {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            if(n == 1 || k == 1) return matrix[0][0];

            PriorityQueue<Dot> que = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                que.add(new Dot(i, 0, matrix[0][i]));
            }
            for (int i = 0; i < k-1; i++) {
                Dot dot = que.poll();
                if(dot.y+1 < n){
                    que.add(new Dot(dot.x, dot.y+1, matrix[dot.y+1][dot.x]));
                }
            }
            return que.poll().val;
        }
    }
    class Dot implements Comparable<Dot>{
        int y;
        int x;
        int val;
        Dot(int x, int y, int val){
            this.y =y;
            this.x =x;
            this.val = val;
        }

        @Override
        public int compareTo(Dot dot) {
            if(this.val < dot.val) return -1;
            else if(this.val > dot.val) return 1;
            return 0;
        }
    }
}
