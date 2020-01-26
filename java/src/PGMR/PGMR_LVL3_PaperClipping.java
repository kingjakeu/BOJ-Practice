package PGMR;

public class PGMR_LVL3_PaperClipping {
    class Solution {
        public int[] solution(int n) {
            int[] answer = {0};

            for (int i = 2; i<=n; i++){
                int offset = 0;
                int preLength = (int)Math.pow(2, i-1) -1;
                int[] tempAnswer = new int[(int)Math.pow(2, i) -1];
                for (int j = 0; j < preLength; j++) {
                    if(j%2 == 0){
                        tempAnswer[j+offset] = 0;
                        tempAnswer[j+offset+1] = answer[j];
                        tempAnswer[j+offset+2] = 1;
                        offset+=2;
                    }else{
                        tempAnswer[j+offset] = answer[j];
                    }
                }
                answer = tempAnswer;
            }

            return answer;
        }
    }
}

