package LEETCODE.medium.bfs;
import java.util.*;

public class Q210_CourseScheduleII {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] answer = new int[numCourses];
            Map<Integer, List<Integer>> postMap = new HashMap<>();
            Map<Integer, Set<Integer>> preMap = new HashMap<>();

            boolean[] visited = new boolean[numCourses];
            for(int[] pre : prerequisites){
                List<Integer> postList = postMap.get(pre[1]);
                if(postList == null) postList = new LinkedList<>();
                postList.add(pre[0]);
                postMap.put(pre[1], postList);

                Set<Integer> preList = preMap.get(pre[0]);
                if(preList == null) preList = new HashSet<>();
                preList.add(pre[1]);
                preMap.put(pre[0], preList);

                visited[pre[0]] = true;
            }

            Queue<Integer> que = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if(!visited[i]) que.add(i);
            }
            visited = new boolean[numCourses];

            int count = 0;
            while (!que.isEmpty()){
                int idx = que.poll();
                visited[idx] = true;
                answer[count++] = idx;

                List<Integer> postList = postMap.get(idx);
                if(postList != null){
                    for(int p : postList){
                        Set<Integer> preSet = preMap.get(p);
                        if(preSet != null) preSet.remove(idx);

                        if(preSet.isEmpty()){
                            if(visited[p]) return new int[0];
                            que.add(p);
                        }
                    }
                }
            }
            if(count == numCourses) return answer;
            else return new int[0];
        }
    }
}
