package LEETCODE;

public class Q200_NumberOfIslands {


}
class Solution {
    public int numIslands(char[][] grid) {
        int count = 2;
        int h = grid.length;
        int w = grid[0].length;
        int[][] offset = {{0,-1}, {-1,0}};
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(grid[i][j] == '1'){
                    boolean check = false;
                    for (int k = 0; k < 2; k++) {
                        int dy = i+offset[k][0];
                        int dx = j+offset[k][1];
                        if(dy>=0 && dx >=0){
                            if(grid[dy][dx] != '0'){
                                grid[i][j] = grid[dy][dx];
                                check = true;
                                k = 3;
                            }
                        }
                    }
                    if(!check){
                        grid[i][j] = (char)count;
                        count += 1;
                    }
                }
            }
        }
        return count-1;
    }
}