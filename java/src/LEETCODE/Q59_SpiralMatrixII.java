package LEETCODE;

public class Q59_SpiralMatrixII {
}
class Q59_SpiralMatrixII_Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        if(n == 0){
            return answer;
        }
        boolean[][] visit = new boolean[n][n];
        int x = 0, y =0, d=0;
        int count = 1;
        while(!visit[y][x]){
            visit[y][x] = true;
            answer[y][x] = count;

            for (int i = 0; i < 4; i++) {
                if(x+dir[d][1]>=0 && x+dir[d][1]<n && y+dir[d][0]>=0 && y+dir[d][0]<n){
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
            count++;
        }
        return answer;
    }
}