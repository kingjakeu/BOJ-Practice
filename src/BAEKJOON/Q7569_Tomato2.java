package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Q7569_Tomato2 {
	public static void main(String[] args) {
		CustomScanner sc = new CustomScanner();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int z = sc.nextInt();
		
		int[][][] map = new int[z][h][w];
		boolean[][] visited = new boolean[h][w];
		int total = 0;
		boolean allVisit = true;
		Queue<DOT> que = new LinkedList();
		int[][] offset = {{0,-1,0},{-1,0,0},{1,0,0},{0,1,0},{0,0,-1},{0,0,1}};
		for(int k=0; k<z; k++) {
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					map[k][i][j] = sc.nextInt();
					if(map[k][i][j] == 1) {
						que.add(new DOT(k,i,j));
					}
					if(map[k][i][j] == 0) {
						total++;
					}
				}
			}
		}
		
		
		int count = -1;
		while(!que.isEmpty()) {
			int leng = que.size();
			for(int k=0; k<leng; k++) {
				DOT d = que.poll();
				for(int i=0; i<6; i++) {
					int dx = d.x+offset[i][0];
					int dy = d.y+offset[i][1];
					int dz = d.z+offset[i][2];
					if(dy>=0 && dy<h && dx>=0 && dx<w && dz>=0 && dz<z) {
						if(map[dz][dy][dx] == 0) {
							map[dz][dy][dx] = 1;
							que.add(new DOT(dz,dy,dx));
							total--;
						}
					}
				}
			}
			count++;
		}
		
		if(total>0) {
			count = -1;
		}
		System.out.println(count);
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
	int x;
	int y;
	int z;
	DOT(int _z, int _y, int _x){
		z = _z;
		x = _x;
		y = _y;
	}
}
