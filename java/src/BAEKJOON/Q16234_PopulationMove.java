package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16234_PopulationMove {
	public static void main(String[] args) {
		CustomScanner sc = new CustomScanner();
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		int[][] map = new int[n][n];
		int[][] off = {{1,0},{-1,0},{0,1},{0,-1}};
		int answer = -1;
		boolean flag = true;
		
		for(int i =0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		while(flag) {
			boolean[][] visit = new boolean[n][n];
			flag = false;
			answer++;
			Queue<Q16234DOT> que = new LinkedList<>();
			ArrayList<Q16234DOT> dlist;
			for(int i =0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visit[i][j]) {
						que.offer(new Q16234DOT(i,j));
						dlist = new ArrayList<>();	
						visit[i][j] = true;
						dlist.add(new Q16234DOT(i,j));
						int total = map[i][j];
						int divr = 1;
						 
						while(!que.isEmpty()) {
							Q16234DOT d = que.poll();
							for(int k=0; k<4; k++) {
								int dx = d.x+off[k][0];
								int dy = d.y+off[k][1];
								if(dx>=0 && dx<n && dy>=0 && dy<n && !visit[dy][dx]) {
									if(Math.abs(map[dy][dx] - map[d.y][d.x])>=l && Math.abs(map[dy][dx] - map[d.y][d.x])<=r) {
										que.add(new Q16234DOT(dy,dx));
										visit[dy][dx] = true;
										dlist.add(new Q16234DOT(dy,dx));
										total += map[dy][dx];
										divr++;
										flag = true;
									}
								}
							}
						}
						int val = total/divr;
						for(Q16234DOT tmp : dlist) {
							map[tmp.y][tmp.x] = val; 
						}
					}
					
				}
			}
		}
		System.out.println(answer);
		
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
class Q16234DOT{
	int y;
	int x;
	
	Q16234DOT(int _y, int _x){
		y = _y;
		x = _x;
	}
}