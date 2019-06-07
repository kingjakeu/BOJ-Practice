import java.util.LinkedList;
import java.util.Queue;

public class PGMR_LVL3_WalkersHeaven {

}
class PGMR_LVL3_WalkersHeaven_Solution {
	 int MOD = 20170805;
	 public int solution(int m, int n, int[][] cityMap) {
	      int answer = 0;
	      int GO = 0, STOP = 1, TURN = 2;
	      int[][] H = new int[m+1][n+1];
	      int[][] V = new int[m+1][n+1];
	      V[1][1] = 1;
	      H[1][1] = 1;
	      for(int i =1; i<=m; i++) {
	    	  for(int j=1; j<=n; j++) {
    			 V[i][j] += V[i-1][j] % MOD;
	    		 H[i][j] += H[i][j-1] % MOD;
	    		 if(cityMap[i-1][j-1] == GO) {
	    			 V[i][j] += H[i][j-1]% MOD;
		    		 H[i][j] += V[i-1][j]% MOD;
	    		 }else if(cityMap[i-1][j-1] == TURN) {
	    			 
	    		 }else if(cityMap[i-1][j-1] == STOP) {
	    			 V[i][j] = 0;
		    		 H[i][j] = 0;
	    		 }
	    	  }
	    	  
	      }
	      
	      return (V[m][n])% MOD;
	 }
}