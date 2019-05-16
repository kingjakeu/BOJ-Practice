//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//import java.util.ArrayList;
//
//public class Q7576_Tomato {
//	public static void main(String[] args) {
//		CustomScanner sc = new CustomScanner();
//		int w = sc.nextInt();
//		int h = sc.nextInt();
//		int[][] map = new int[h][w];
//		boolean[][] visited = new boolean[h][w];
//		int total = 0;
//		boolean allVisit = true;
//		Queue<DOT> que = new LinkedList();
//		int[][] offset = {{0,-1},{-1,0},{1,0},{0,1}};
//		for(int i=0; i<h; i++) {
//			for(int j=0; j<w; j++) {
//				map[i][j] = sc.nextInt();
//				if(map[i][j] == 1) {
//					que.add(new DOT(i,j));
//				}
//				if(map[i][j] == 0) {
//					total++;
//				}
//			}
//		}
//		
//		int count = -1;
//		while(!que.isEmpty()) {
//			int leng = que.size();
//			for(int k=0; k<leng; k++) {
//				DOT d = que.poll();
//				if(!visited[d.y][d.x]) {
//					visited[d.y][d.x] = true;
//					for(int i=0; i<4; i++) {
//						int dx = d.x+offset[i][0];
//						int dy = d.y+offset[i][1];
//						if(dy>=0 && dy<h && dx>=0 && dx<w) {
//							if(map[dy][dx] == 0 &&!visited[dy][dx]) {
//								map[dy][dx] = 1;
//								que.add(new DOT(dy,dx));
//								total--;
//							}
//						}
//					}
//				}
//			}
//			count++;
//		}
//		
//		if(total>0) {
//			count = -1;
//		}
//		System.out.println(count);
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
//	int x;
//	int y;
//	DOT(int _y, int _x){
//		x = _x;
//		y = _y;
//	}
//}
