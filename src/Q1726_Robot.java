//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//
//public class Q1726_Robot {
//	public static void main(String[] args) {
//		CustomScanner sc = new CustomScanner();
//		int m = sc.nextInt();
//		int n = sc.nextInt();
//		int[][] map = new int[m][n];
//		boolean[][][] cache = new boolean[5][m][n];
//		int[][] visit = new int[m][n];
//		
//		int[][] off = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
//		for(int i=0; i<m; i++) {
//			for(int j=0; j<n; j++) {
//				map[i][j] = sc.nextInt();
//			}
//		}
//		Queue<DOT> que = new LinkedList<>();
//		
//		int y = sc.nextInt()-1;
//		int x = sc.nextInt()-1;
//		int dir = sc.nextInt();
//		cache[dir][y][x] = true;
//		DOT start = new DOT(y,x,dir,0);
//		que.add(start);
//		
//		y = sc.nextInt()-1;
//		x = sc.nextInt()-1;
//		dir = sc.nextInt();
//		DOT end = new DOT(y,x,dir,0);
//		
//		while(!que.isEmpty()) {
//			DOT d = que.poll();
//			y = d.y;
//			x = d.x;
//			dir = d.dir;
//			int step = d.step;
//			
//			if(x == end.x && y == end.y && dir == end.dir) {
//				System.out.println(step);
//				break;
//			}
//			for(int i=1; i<=3; i++) {
//				int dx = (off[d.dir][0]*i)+x;
//				int dy = (off[d.dir][1]*i)+y;
//				
//				if(dx>=0 && dx<n && dy>=0 && dy<m) {
//					if(map[dy][dx] ==0) {
//						if(!cache[dir][dy][dx]) {
//
//							cache[dir][dy][dx] = true;
//							que.add(new DOT(dy, dx, dir, step+1));
//						}
//					}else {
//						break;
//					}
//				}
//				
//			}
//			for(int i=1; i<=4; i++) {
//				if(dir != i && !cache[i][y][x]) {
//					cache[i][y][x] = true;
//					if((off[dir][0]+off[i][0] ==0) && (off[dir][1]+off[i][1] ==0)) {
//						que.add(new DOT(y,x,i,step+2));
//					}else {
//						que.add(new DOT(y,x,i,step+1));
//					}
//				}
//			}
//		}
//		
//		
//	}
//	static class CustomScanner{
//		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		static StringTokenizer st = new StringTokenizer("");
//		
//		static String next() {
//			while(!st.hasMoreTokens()) {
//				try {
//					st = new StringTokenizer(br.readLine());
//				}catch(IOException e) {
//					
//				}
//			}
//			return st.nextToken();
//		}
//		static int nextInt() {
//			return Integer.parseInt(next());
//		}
//	}
//}
//class DOT{
//	int y;
//	int x;
//	int dir;
//	int step = 0; 
//	DOT(int _y, int _x, int _dir){
//		y = _y;
//		x = _x;
//		dir = _dir;
//	}
//	DOT(int _y, int _x, int _dir, int b){
//		y = _y;
//		x = _x;
//		dir = _dir;
//		step = b;
//	}
//}