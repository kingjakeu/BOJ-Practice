package LEETCODE;

public class Q63_UniquePathsII {
}
class Q63_UniquePathsII_Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int h = obstacleGrid.length;
        int w = 0;
        if (h>0){
            w = obstacleGrid[0].length;
        }
        int[][] cache = new int[h][w];

        int tmp = 1;
        for (int i = 0; i < w; i++) {
            if(obstacleGrid[0][i] == 1){
               tmp = 0;
            }
            cache[0][i] = tmp;
        }
        tmp = 1;
        for (int i = 0; i < h; i++) {
            if(obstacleGrid[i][0] == 1){
                tmp = 0;
            }
            cache[i][0] = tmp;
        }

        if(obstacleGrid[0][0] == 1){
            return 0;
        }else{
            cache[0][0] = 1;
        }
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if(obstacleGrid[i][j] == 0){
                    if(cache[i][j-1] != 0){
                        cache[i][j] += cache[i][j-1];
                    }
                    if(cache[i-1][j] != 0){
                        cache[i][j] += cache[i-1][j];
                    }

                }
            }
        }
        return cache[h-1][w-1];
    }
}