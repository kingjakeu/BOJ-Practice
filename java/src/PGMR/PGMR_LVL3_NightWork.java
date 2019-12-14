package PGMR;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
public class PGMR_LVL3_NightWork {

}
class PGMR_LVL3_NightWork_Solution {
    public long solution(int n, int[] works) {
       long answer = 0;
       int leng = works.length;
       Arrays.sort(works);
       PriorityQueue<Integer> que = new PriorityQueue<>(leng, Collections.reverseOrder());
       for(int i : works) {
    	   que.add(i);
    	   answer += i;
       }
       if(answer <= n) {
    	   return 0;
       } 
       answer = 0;
       for(int i=0; i<n; i++) {
    	   if(que.isEmpty()) {
    		   break;
    	   }
    	   int tmp = que.poll();
    	   tmp--;
    	   if(tmp > 0) {
        	   que.add(tmp);
    	   }
       }
       for(int i : que) {
    	   answer += i*i;
       }
       return answer;
    }
}
