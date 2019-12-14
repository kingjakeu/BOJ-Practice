package PGMR;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGMR_LVL3_BestSet {

}
class PGMR_LVL3_BestSet_Solution {
	 public int[] solution(int n, int s) {
	     int[] answer = {-1};
	     if(n>s) {
	    	 return answer;
	     }
	     answer = new int[n];
	     Queue<Integer> que = new LinkedList<>();
	     int tmp = s/n;
	     if(tmp<=0) {
	    	 tmp = 1;
	     }
	     int sum = 0;
	     for(int i=0; i<n; i++) {
	    	 que.add(tmp);
	    	 sum+=tmp;
	     }
	     while(sum != s) {
	    	 if(sum < s) {
	    		 sum++;
	    		 int t = que.poll();
	    		 t++;
	    		 que.add(t);
	    	 }else {
	    		 sum--;
	    		 int t = que.poll();
	    		 t--;
	    		 que.add(t);
	    	 }
	     }
	     for(int i=0; i<n; i++) {
	    	 answer[i] = que.poll();
	     }
	     return answer;
	 }
}
