package PGMR;

public class PGMR_KAKAO_KeyAndLock {
    class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = true;
            return answer;
        }

        public int[][] turnClockwise(int[][] key, int m){
            int[][] arr = new int[m][m];
            int max = m-1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = key[j][max-i];
                }
            }
            return arr;
        }
    }
}
