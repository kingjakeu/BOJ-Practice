package PGMR;

import java.util.Arrays;

public class PGMR_LVL3_Scale {

}
class PGMR_LVL3_Scale_Solution {
    public int solution(int[] weight) {
        int answer = 1;
        Arrays.sort(weight);
        if(weight[0] > 1) return answer;
        for(int i : weight) {
        	if(i >answer+1) return answer;
        	answer += i;
        }
        return answer;
    }
}