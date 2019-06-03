import java.util.Arrays;

public class PGMR_LVL3_Budget {
	
}
class PGMR_LVL3_Budget_Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        Arrays.sort(budgets);
        
        int leng = budgets.length;
        int min = 0;
        int max = M;
        int premid = 0, mid =0;
        long sum =0;
        
        for(int i: budgets) {
        	sum+=i;
        }
       
        if(sum<M) {
        	answer = budgets[leng-1];
        	return answer;
        }else {
        	while(true) {
            	sum = 0;
            	mid = (max+min)/2;
      
            	if(mid == premid) {
            		break; 
            	}

            	for(int i=0; i<leng; i++) {
            		if(mid <= budgets[i]) {
            			sum += mid*(leng-i);
            			break;
            		}else {
            			sum += budgets[i];
            		}
            	}
            	if(sum <= M) {
            		min = mid;
            	}else {
            		max = mid;
            	}
            	premid = mid;
            }
            answer = mid;
        }
        
        return answer;
    }
}