package PGMR;

import java.util.LinkedList;
import java.util.Queue;

public class PGMR_LVL3_GoingToSchool {

}
class PGMR_LVL3_GoingToSchool_Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        int[][] offset = {{1,0},{-1,0},{0,1},{0,-1}};
        visit[0][0] = true;
        
        for(int[] p : puddles) {
        	visit[p[1]-1][p[0]-1] = true;
        }
        Queue<GTSdot> que = new LinkedList<>();
        que.add(new GTSdot(0,0));
        map[0][0] = 1;
        while(!que.isEmpty()) {
        	GTSdot dot = que.poll();
        	for(int i=0; i<4; i++) {
            	int dx = dot.x + offset[i][0];
            	int dy = dot.y + offset[i][1];
            	if(dx>=0 && dx <m && dy>=0 && dy<n) {
            		if(!visit[dy][dx]) {
            			visit[dy][dx] = true;
            			que.add(new GTSdot(dy,dx));
            			map[dy][dx] = map[dot.y][dot.x];
            		}else {
            			map[dy][dx] = (map[dy][dx]+map[dot.y][dot.x])%1000000007;
            		}
            	}
            }
        }
        if(m>=100) {
        	int t = 2/0;
        }
        
        return map[n-1][m-1];
    }
}
class GTSdot{
	int x;
	int y;
	public GTSdot(int _y, int _x) {
		y = _y;
		x = _x;
	}
}