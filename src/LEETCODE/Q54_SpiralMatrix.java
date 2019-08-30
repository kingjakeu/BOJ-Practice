package LEETCODE;

import java.util.LinkedList;
import java.util.List;

public class Q54_SpiralMatrix {
}
class Q54_SpiralMatrix_Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new LinkedList<>();
        int row = matrix.length;
        int col = 0;
        if(row>0){
            col = matrix[0].length;
        }else{
            return answer;
        }
        boolean[][] visit = new boolean[row][col];
        int x = 0, y =0, d=0;
        while(!visit[y][x]){
            visit[y][x] = true;
            answer.add(matrix[y][x]);
            for (int i = 0; i < 4; i++) {
                if(x+dir[d][1]>=0 && x+dir[d][1]<col && y+dir[d][0]>=0 && y+dir[d][0]<row){
                    if(!visit[y+dir[d][0]][x+dir[d][1]]){
                        x += dir[d][1];
                        y += dir[d][0];
                        break;
                    }else{
                        d += 1;
                        if(d==4){
                            d = 0;
                        }
                    }
                }else{
                    d += 1;
                    if(d==4){
                        d = 0;
                    }
                }
            }
        }
        return answer;
    }
}