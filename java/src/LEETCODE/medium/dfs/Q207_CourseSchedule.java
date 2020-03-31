package LEETCODE.medium.dfs;

import java.util.*;

public class Q207_CourseSchedule {
    class Solution {
        int length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            length = prerequisites.length;
            for (int i = 0; i < length; i++) {
                List <Integer> list = (map.containsKey(prerequisites[i][0])) ? map.get(prerequisites[i][0]) : new LinkedList<>();
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], list);
            }

            for (int i = 0; i < numCourses; i++) {
                if(map.containsKey(i)){
                    boolean[] visited = new boolean[numCourses];
                    visited[i] = true;
                    if(!search(map.get(i), new boolean[numCourses])) return false;
                }
            }
            return true;
        }
        public boolean search(List<Integer> pre, boolean[] visited){
            if(pre != null){
                for(int p : pre){
                    if(visited[p]) return false;
                    visited[p] = true;
                    if(!search(map.get(p), visited)) return false;
                    visited[p] = false;
                }
            }
            return true;
        }
    }
}
