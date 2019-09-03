package LEETCODE;

public class Q62_UniquePath {
}
class Q62_UniquePath_Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[n][m];
        if(m>0 && n >0){
            for (int i = 0; i < m; i++) {
                cache[0][i] = 1;
            }
            for (int i = 0; i < n; i++) {
                cache[i][0] = 1;
            }
            cache[0][0] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    cache[i][j] = cache[i][j-1]+cache[i-1][j];
                }
            }
            return cache[n-1][m-1];
        }
        return 0;
    }
}