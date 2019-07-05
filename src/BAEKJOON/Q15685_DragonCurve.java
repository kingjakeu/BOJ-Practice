package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15685_DragonCurve {
	static boolean map[][] = new boolean[101][101];
	static int[][] offset = {{1,0},{0,-1},{-1,0},{0,1}};
	public static void main(String[] args) {
		CustomScanner sc = new CustomScanner();
		int n = sc.nextInt();
		for(int c=0; c<n; c++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			Q15685_DOT idx  = new Q15685_DOT(x,y);
			ArrayList<Integer> dir = new ArrayList<>();
			dir.add(d);

			map[idx.y][idx.x] = true; 
			idx.x += offset[d][0];
			idx.y += offset[d][1];
			map[idx.y][idx.x] = true; 
			int off = 0;
			for(int i=0; i<g; i++) {
				int leng = dir.size();
				for(int j = 0; j<leng; j++) {
					off = dir.get(j);
					//System.out.println(idx.x+" "+idx.y+" "+off);
					map[idx.y][idx.x] = true;
					if(off == 3) {
						off = 0;
					}else {
						off++;
					}
					idx.x += offset[off][0];
					idx.y += offset[off][1];
					dir.add(0, off);
					leng++;
					j++;
				}
			}
			map[idx.y][idx.x] = true;
			//System.out.println(idx.x+" "+idx.y+" "+off);
		}
		int count = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[j][i]) {
					//System.out.println(i+ " "+j);
					if(map[j+1][i]&&map[j][i+1]&&map[j+1][i+1]) {
						count++;
					}
				}
			}
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
class Q15685_DOT{
	int x;
	int y;
	Q15685_DOT(int _x, int _y){
		x = _x;
		y = _y;
	}
}