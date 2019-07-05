package PGMR;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class PGMR_LVL3_MostFarNode {

}

class PGMR_LVL3_MostFarNode_Solution {
   public int solution(int n, int[][] edge) {
	   int answer = 0;
       ArrayList<ArrayList<Integer>> list = new <ArrayList<Integer>> ArrayList();
       Queue<Integer> que = new LinkedList<Integer>();
       int[] d = new int[n+1];

       for(int i = 0; i < edge.length; i++) {
    	   list.add(new ArrayList<Integer>()); 
       }
       for(int i = 0; i < edge.length; i++) {
           list.get(edge[i][0]).add(edge[i][1]);
           list.get(edge[i][1]).add(edge[i][0]);
       }
       que.add(1);
       
       while(!que.isEmpty()) {
    	   int tmp = que.poll();
    	   for(int i : list.get(tmp)) {
    		   if(d[i] == 0) {
    			   d[i] = d[tmp]+1;
    			   que.add(i);
    		   }
    	   }
       }
       int max = 0;
       for(int i=2; i<=n; i++) {
    	  System.out.println(i);
    	  max = Math.max(d[i], max);
       }
       for(int i=2; i<=n; i++) {
    	   if(max==d[i]) {
    		   answer++;
    	   }
       }
       
       return answer;
   }
}