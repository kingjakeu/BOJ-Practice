import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		CustomScanner sc = new CustomScanner();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] map = new int[m][n];
		boolean[][] visit = new boolean[m][n];
		
		int[][] off = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Queue<DOT> que = new LinkedList<>();
		
		int y = sc.nextInt()-1;
		int x = sc.nextInt()-1;
		int dir = sc.nextInt();
		DOT start = new DOT(y,x,dir);
		que.add(start);
		y = sc.nextInt()-1;
		x = sc.nextInt()-1;
		dir = sc.nextInt();
		DOT end = new DOT(y,x,dir);
		visit[start.y][start.x] = true;
		while(!que.isEmpty()) {
			DOT d = que.poll();
			
			for(int i=1; i<=4; i++) {
				int dx = d.x+off[i][0];
				int dy = d.y+off[i][1];
				if(dx>=0 && dx<n && dy>=0 && dy<m && !visit[dy][dx] && map[dy][dx] == 0) {
					//System.out.println(d.y+" "+d.x+" "+dy+" "+dx+" "+i);
					if(d.dir == i) {
						int ox = dx, oy = dy;
						
						map[dy][dx] += map[d.y][d.x]+1;
						visit[dy][dx] = true;
						
						for(int p =0; p<2; p++) {
							int ddx = dx+off[i][0];
							int ddy = dy+off[i][1];
							if(ddx>=0 && ddx<n && ddy>=0 && ddy<m && !visit[ddy][ddx] && map[ddy][ddx] == 0) {
								map[ddy][ddx] += map[dy][dx];
								visit[ddy][ddx] = true;
								ox = ddx;
								oy = ddy;
							}
						}
						que.offer(new DOT(oy,ox,i));
					}else if((off[dir][0]+off[i][0] ==0) &&(off[dir][1]+off[i][1] ==0)  ) {
						map[dy][dx] = map[d.y][d.x]+2;
						que.offer(new DOT(dy,dx,i));
					}else {	
						map[dy][dx] = map[d.y][d.x]+1;
						que.offer(new DOT(dy,dx,i));
					}
				}

			}

			System.out.println();
			for(int l=0; l<m; l++) {
				for(int j=0; j<n; j++) {
					System.out.print(map[l][j]+" ");
				}
				System.out.println();
			}

		}
		System.out.println(map[end.y][end.x]);
		
	}
	static class CustomScanner{
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer st = new StringTokenizer("");
		
		static String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				}catch(IOException e) {
					
				}
			}
			return st.nextToken();
		}
		static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
class DOT{
	int y;
	int x;
	int dir;
	DOT(int _y, int _x, int _dir){
		y = _y;
		x = _x;
		dir = _dir;
	}
}