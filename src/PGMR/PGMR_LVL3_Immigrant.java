package PGMR;

import java.util.Arrays;

public class PGMR_LVL3_Immigrant {

}
class PGMR_LVL3_Immigrant_Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int leng = times.length;
        Arrays.sort(times);
        long min = 1;
        long max = Long.MAX_VALUE-1;
        long mid = (max+min)/2;
    	long totalTime = 0;
    	
        while(min+1< max) {
        	totalTime = 0;
        	long sum = max+min;
        	if(sum<0) {
        		mid = Long.MAX_VALUE/2;
        	}else {
            	mid = sum/2;
        	}
        	long count = counting(mid, times);
        	
        	if(count<(long)n) {
        		min = mid;
        	}else{
        		max = mid;
        	}
        	//System.out.println(totalTime+" "+min+" "+max);
        }
        
        if(counting(min, times) >= n) {
        	answer = min;
        }else {
        	answer = max;
        }
        return answer;
    }
    public long counting(long mid, int[] times) {
        long count = 0;
        for (int time : times) {
            if (time <= mid) {
                count += (mid / time);
            }
        }
        if(count<0) {
        	count = Long.MAX_VALUE;
		}
        return count;
    }
}
