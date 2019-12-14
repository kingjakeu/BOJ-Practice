package LEETCODE;

public class Q48_RotateImage  {
}
class Q48_RotateImage_Solution {
    public void rotate(int[][] matrix) {
        int leng = matrix.length;
        int[][] answer = new int[leng][leng];
        for (int i = 0; i < leng; i++) {
            for (int j=0; j<leng; j++){
                answer[j][leng-i-1] = matrix[i][j];
            }
        }
        for (int i = 0; i < leng; i++) {
            for (int j=0; j<leng; j++){
               matrix[i][j] = answer[i][j];
            }
        }
    }
}