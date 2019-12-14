package PGMR;

import java.util.LinkedList;
import java.util.Queue;

public class PGMR_KAKAO_NUM6 {
    public static void main(String[] args) {
        PGMR_KAKAO_NUM6_Solution s = new PGMR_KAKAO_NUM6_Solution();
        int[][] map = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        s.solution(map);
    }
}
class PGMR_KAKAO_NUM6_Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[][] cost = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 1){
                    visited[i][j] = true;
                }
            }
        }
        int[][][] turn = {
                {{-1,0},{1,0},{-1,1},{1,1}},
                {{0,-1},{0,1},{1,-1},{1,1}}
        };
        int[][] move ={{-1,0},{0,1},{1,0},{0,-1}};
        Queue<KakaoRobot> que = new LinkedList<>();
        que.add(new KakaoRobot(0,0, 0,1,0));
        visited[0][0] = true;
        visited[0][1] = true;
        while(!que.isEmpty()){
            KakaoRobot robot = que.poll();
            visited[robot.y][robot.x] = true;
            visited[robot.ty][robot.tx] = true;
            if(visited[n-1][n-1]){
                break;
            }
            for(int[] cs : cost){
                for (int c : cs){
                    System.out.print(c);
                }
                System.out.println();
            }
            System.out.println();
            for(int i =0; i<2; i++){
                int dy = robot.y + turn[robot.dr][i][0];
                int dx = robot.x + turn[robot.dr][i][1];
                int safey = robot.y + turn[robot.dr][i+2][0];
                int safex = robot.x + turn[robot.dr][i+2][1];
                if(dy>=0 && dy<n && dx>=0 && dx<n){
                    if(safey>=0 && safey<n && safex>=0 && safex<n) {
                        if (!visited[dy][dx] && board[dy][dx] == 0 && board[safey][safex] == 0) {
                            //visited[dy][dx] = true;
                            int tmpCost = cost[robot.y][robot.x] + 1;
                            cost[dy][dx] = (cost[dy][dx]>0) ? Math.min(cost[dy][dx], tmpCost) : tmpCost;
                            int newD = 0;
                            if (robot.dr == 0) {
                                newD = 1;
                            }
                            que.add(new KakaoRobot(robot.y, robot.x, dy, dx, newD));
                        }
                    }
                }
            }
            for(int i =2; i<4; i++){
                int dy = robot.ty + turn[robot.dr][i-2][0];
                int dx = robot.tx + turn[robot.dr][i-2][1];
                int safey = robot.ty + turn[robot.dr][i][0];
                int safex = robot.tx + turn[robot.dr][i][1];
                if(dy>=0 && dy<n && dx>=0 && dx<n){
                    if(safey>=0 && safey<n && safex>=0 && safex<n) {
                        if (!visited[dy][dx] && board[dy][dx] == 0 && board[safey][safex] == 0) {
                            //visited[dy][dx] = true;
                            int tmpCost = cost[robot.ty][robot.tx] + 1;
                            cost[dy][dx] = (cost[dy][dx]>0) ? Math.min(cost[dy][dx], tmpCost) : tmpCost;
                            int newD = 0;
                            if (robot.dr == 0) {
                                newD = 1;
                            }
                            que.add(new KakaoRobot(robot.ty, robot.tx, dy, dx, newD));
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int dy = robot.y + move[i][0];
                int dx = robot.x + move[i][1];
                int dty = robot.ty + move[i][0];
                int dtx  =robot.tx + move[i][1];
                if(dy>=0 && dy<n && dx>=0 && dx<n){
                    if(dty>=0 && dty<n && dtx>=0 && dtx<n){
                        if(!visited[dy][dx] || !visited[dty][dtx]){
                            if(board[dy][dx]==0 && board[dty][dtx]==0){
                                //visited[dy][dx] = true;
                                //visited[dty][dtx] = true;
                                int dcost = cost[robot.y][robot.x]+1;
                                int tcost = cost[robot.ty][robot.tx]+1;
                                cost[dy][dx] = (cost[dy][dx]>0) ? Math.min(cost[dy][dx], dcost) : dcost;
                                cost[dty][dtx] = (cost[dty][dtx]>0) ? Math.min(cost[dty][dtx], tcost) : tcost;
                                que.add(new KakaoRobot(dy,dx,dty,dtx,robot.dr));
                            }
                        }

                    }
                }
            }
        }
        return cost[n-1][n-1];
    }
}

class KakaoRobot{
    int y;
    int x;
    int ty;
    int tx;
    int dr;
    KakaoRobot(int _y, int _x, int _ty, int _tx, int _dr){
        y = _y;
        x =_x;
        ty = _ty;
        tx = _tx;
        dr = _dr;
    }
}