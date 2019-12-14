package PGMR;

public class PGMR_LVL3_TENT {
}
class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(data[i][0] == data[j][0] || data[j][1] == data[i][1]){
                    continue;
                }
                int minX = Math.min(data[i][0],data[j][0]);
                int maxX = Math.max(data[i][0],data[j][0]);
                int minY = Math.min(data[i][1],data[j][1]);
                int maxY = Math.max(data[i][1],data[j][1]);
                boolean check = false;
                for (int k = 0; k < n; k++) {
                    if(k!=i && k!=j){
                        if(data[k][0]>minX && data[k][0]<maxX && data[k][1]>minY && data[k][1]<maxY){
                            check = true;
                            break;
                        }
                    }
                }
                if(!check){
                    answer += 1;
                }
            }
        }
        return answer;
    }
}