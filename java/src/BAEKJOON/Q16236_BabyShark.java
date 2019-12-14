package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16236_BabyShark {
static int[][] map;
	
	public static void main(String[] args) {
		CustomScanner sc = new CustomScanner();
		int n = sc.nextInt();
		map = new int[n][n];
		Q16236DOT shark;
		int ssize = 2;
		int scount = 0;
		int[][] offset = {{0,-1},{-1,0},{1,0},{0,1}};
		Queue<Q16236DOT> que = new LinkedList<>();
		
		int cost = 0;
		
		for(int i =0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					map[i][j] = 0;
					shark = new Q16236DOT(i,j);
					que.add(shark);
				}
			}
		}
		while(true) {
			int[][] cache = new int[n][n];
			LinkedList<Q16236DOT> eat = new LinkedList<>();
			while(!que.isEmpty()) {
				Q16236DOT d = que.poll();
				for(int i=0; i<4; i++) {
					int dx = d.x+offset[i][0];
					int dy = d.y+offset[i][1];
					if(dx>=0 && dx<n && dy>=0 && dy<n && cache[dy][dx] ==0) {
						if(map[dy][dx] <= ssize) {
							cache[dy][dx] = cache[d.y][d.x] +1;
												
							if(map[dy][dx] < ssize && map[dy][dx] > 0) {
								Q16236DOT ate = new Q16236DOT(dy,dx,cache[dy][dx]);
								eat.add(ate);
							}
							que.add(new Q16236DOT(dy,dx));
						}
					}
				}
			}
			if(eat.size() == 0) {
				System.out.println(cost);
				break;
			}
			Q16236DOT min = eat.get(0);
			for(int i=1; i<eat.size(); i++) {
				if(min.r > eat.get(i).r) {
					min = eat.get(i);
				}else if(min.r == eat.get(i).r) {
					if(min.y > eat.get(i).y) {
						min = eat.get(i);
					}else if(min.y == eat.get(i).y) {
						if(min.x > eat.get(i).x) {
							min = eat.get(i);
						}
					}
				}
			}
			cost += min.r;
			scount++;
			if(ssize == scount) {
				ssize++; 
				scount =0;
			}
			map[min.y][min.x] = 0;
			que.add(min);
		}
		
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
class Q16236DOT{
	int x;
	int y;
	int r;
	
	Q16236DOT(int _y, int _x){
		y = _y;
		x = _x;
	}
	Q16236DOT(int _y, int _x, int _r){
		y = _y;
		x = _x;
		r = _r;
	}
	
}