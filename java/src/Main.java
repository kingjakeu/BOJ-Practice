import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();
		int[][] arr = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
 		System.out.println(solution.solution(4, arr));
	}

	static class Solution {
		int[][] map;
		int min = Integer.MAX_VALUE;
		public int solution(int n, int[][] costs) {
			map = new int[n][n];
			for(int[] cost : costs){
				int x = cost[0];
				int y = cost[1];
				int c = cost[2];
				map[y][x] = map[y][x] > 0 ? Math.min(map[y][x], c) : c;
				map[x][y] = map[x][y] > 0 ? Math.min(map[x][y], c) : c;
			}
			boolean[][] visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				visited[i][i] = true;
				for (int j = 0; j < n; j++) {
					if(!visited[i][j] && map[i][j] > 0){
						visited[i][j] = true;
						find(i, n, map[i][j], visited);
						visited[i][j] = false;
					}
				}
			}
			return min;
		}

		public void find(int idx, int n, int sum, boolean[][] visited){

			min = Math.min(min, sum);
		}
	}
}
