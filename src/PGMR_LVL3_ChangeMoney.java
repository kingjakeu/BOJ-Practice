
public class PGMR_LVL3_ChangeMoney {

}
class PGMR_LVL3_ChangeMoney_Solution {
	public int solution(int n, int[] money) {
	      int answer = 0;
	      int leng = money.length;
	      int[] cache = new int[100001];
	      cache[0] = 1;
	     
	      for(int i=0; i<leng; i++) {
	    	  for(int j=1; j<=n; j++) {
	    		  if(j-money[i] >= 0) {
	    			  cache[j] += (cache[j-money[i]])%1000000007;
	    		  }
	    	  }
	      }
	      
	      return cache[n];
	}
}