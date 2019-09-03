package LEETCODE;

public class Q64_MinimumPathSum {
}
class Q64_MinimumPathSum_Solution {
    public int minPathSum(int[][] grid) {
        int h  = grid.length;
        int w = 0;
        if(h>0){
            w = grid[0].length;
        }
        if(w>0){
            int[][] cache = new int[h][w];
            cache[0][0] = grid[0][0];
            for (int i = 1; i < h; i++) {
                cache[i][0] = cache[i-1][0]+grid[i][0];
            }
            for (int i = 1; i < w; i++) {
                cache[0][i] = cache[0][i-1]+grid[0][i];
            }
            for (int i = 1; i < h; i++) {
                for (int j = 1; j < w; j++) {
                    cache[i][j] = grid[i][j] + Math.min(cache[i-1][j],cache[i][j-1]);
                }
            }
            return cache[h-1][w-1];
        }
        return 0;
    }
}
