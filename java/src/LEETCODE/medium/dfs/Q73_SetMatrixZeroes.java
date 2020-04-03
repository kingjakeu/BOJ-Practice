package LEETCODE.medium.dfs;

public class Q73_SetMatrixZeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            int h = matrix.length;
            if(h == 0) return;
            int w = matrix[0].length;
            boolean[][] check = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(matrix[i][j] == 0 && !check[i][j]){
                        for (int k = 0; k < h; k++) {
                            if(matrix[k][j] != 0){
                                check[k][j] = true;
                                matrix[k][j] = 0;
                            }
                        }
                        for (int k = 0; k < w; k++) {
                            if(matrix[i][k] != 0){
                                check[i][k] = true;
                                matrix[i][k] = 0;
                            }
                        }
                        check[i][j] = false;
                    }
                }
            }
        }
    }
}
