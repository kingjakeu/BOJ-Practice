package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018_ChessPan {
	static char[][] pan;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		pan = new char[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<m; j++) {
				pan[i][j] = str.charAt(j);
			}
		}
		int answer = 64;
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				answer = Math.min(search(i,j,0), answer);
				answer = Math.min(search(i,j,1), answer);
			}
		}
		System.out.println(answer);
	}
	public static int search(int y, int x, int c) {
		int count = 0;
		char[] color = {'W','B'};
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(pan[i+y][j+x] != color[c]) {
					count++;
				}
				if(c == 0) c++;
				else c--;
			}
			if(c == 0) c++;
			else c--;
		}
		return count;
	}
}
