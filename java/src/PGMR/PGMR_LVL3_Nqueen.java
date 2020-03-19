package PGMR;

public class PGMR_LVL3_Nqueen {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(4);
    }
    static class Solution {
        int[][] offset = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        public int solution(int n) {
            int answer = 0;
            boolean[][] map = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                answer += search(i,1, n, map);
            }
            return answer;
        }
        public int search(int x, int y, int n, boolean[][] map){
            if(y == n) return 1;
            int count = 0 ;
            map[y-1][x] = true;
            for (int i = 0; i < n; i++) {
                if(isSafe(i, y, n, map)){
                    count += search( i, y+1, n, map);
                }
            }

            map[y-1][x] = false;
            return count;
        }

        public boolean isSafe(int x, int y, int n, boolean[][] map){
            for (int i = 0; i < n; i++) {
                if(map[i][x]) {
                    return false;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 4; j++) {
                    int dx = x+(offset[j][0] * (i+1));
                    int dy = y+(offset[j][1] * (i+1));
                    if(dx >= 0 && dx < n && dy >= 0 && dy < n){
                        if(map[dy][dx]) return false;
                    }
                }
            }
            return true;
        }
    }
}
