import java.util.ArrayList;

public class PGMR_LVL3_WayToLineup {

}
class PGMR_LVL3_WayToLineup_Solution {
	  public int[] solution(int n, long k) {
	      int[] answer = new int[n];
	      ArrayList<Integer> list = new ArrayList<>();
	      long fact = 1;
	      k--;
          int divd = 0;
	      for(int i = 1; i<= n; i++) {
	    	  fact = fact*i;
	    	  list.add(i);
	      }
	      for(int i=n; i>0; i--) {
              fact = (long)(fact/i);
              divd = (int)(k/fact);
              answer[n-i] = list.get(divd);
              list.remove(divd);
              k = k % fact;
	      }
	      return answer;
	  }
}