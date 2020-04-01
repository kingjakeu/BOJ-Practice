package LEETCODE.medium.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q279_PerfectSquares {
    class Solution {
        public int numSquares(int n) {
            List<Integer> squareSet = new ArrayList<>();
            int length = 0;
            for (int i = 1; i*i <= n ; i++) {
                squareSet.add(i*i);
                length++;
            }

            Queue<Dot> que = new LinkedList<>();
            que.add(new Dot(n, 0, length-1));

            boolean[] visited = new boolean[n+1];

            while(!que.isEmpty()){
                Dot dot = que.poll();
                visited[dot.value] = true;
                if(dot.value == 0){
                    return dot.count;
                }
                for (int i = dot.lastIdx; i >= 0; i--) {
                    int tmp = dot.value - squareSet.get(i);
                    if(tmp >= 0 && !visited[tmp]){
                        que.add(new Dot(tmp, dot.count+1, i));
                    }
                }
            }
            return n;
        }
    }
    class Dot{
        int value;
        int count;
        int lastIdx;
        Dot(int value, int count, int lastIdx){
            this.value = value;
            this.count = count;
            this.lastIdx = lastIdx;
        }
    }
}
