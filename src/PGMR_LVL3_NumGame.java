import java.util.Arrays;
public class PGMR_LVL3_NumGame {

}

class PGMR_LVL3_NumGame_Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int leng = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;
        
        for(int i=0; i<leng; i++){
            if(idx<leng){
                if(A[i] < B[idx]){
                    answer++;
                }else{
                    i--;
                }
                idx++;
            }
            
        }
        return answer;
    }
}