import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576_Tomato {
	public static void main(String[] args) {
		CustomScanner sc = new CustomScanner();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int[][] map = new int[h][w];
		boolean[][] visited = new boolean[h][w];
		
		Queue<DOT> que = new LinkedList();
		int[][] offset = {{0,-1},{-1,0},{1,0},{0,1}};
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					que.add(new DOT(i,j));
				}
			}
		}
		int count = 0;
		while(!que.isEmpty()) {
			DOT d = que.poll();
			visited[d.y][d.x] = true;
			
			for(int i=0; i<4; i++) {
				int dx = d.x+offset[i][0];
				int dy = d.y+offset[i][1];
				if(dy>=0 && dy<h && dx>=0 && dx<w) {
					if(map[dy][dx] == 0 &&!visited[dy][dx]) {
						map[dy][dx] = 1;
						que.offer(new DOT(dy,dx));
					}
				}
			}
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			count++;
			System.out.println();
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
	DOT(int _y, int _x){
		x = _x;
		y = _y;
	}
}
