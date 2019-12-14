package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3665_FinalRank {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	
	public static void main(String[] args) {
		int testcase = nextInt();
	
		for(int t =0; t<testcase; t++) {
			int n = nextInt();
			boolean[][] map = new boolean[n][n];
			int[] inDegree = new int[n];
			ArrayList<Integer> tmpRank = new ArrayList<>();
			boolean question = false;
			
			for(int i=0; i<n; i++) {
				tmpRank.add(nextInt()-1);
			}
			for(int i=0; i<n; i++) {
				int tr = tmpRank.get(i);
				for(int j=i+1; j<n; j++) {
					int out = tmpRank.get(j);
					map[tr][out] = true;
					inDegree[out]++;
				}
			}
			int m = nextInt();
			for(int i=0; i<m; i++) {
				int head = nextInt() -1;
				int out = nextInt() -1 ;
				if(map[head][out]) {
					map[head][out] = false;
					map[out][head] = true;
					inDegree[head]++;
					inDegree[out]--;
				}else {
					map[head][out] = true;
					map[out][head] = false;
					inDegree[head]--;
					inDegree[out]++;
				}
			}
			
			Queue<Integer> que = new LinkedList<>();
			tmpRank.clear();
			
			for(int i=0; i<n; i++) {
				if(inDegree[i] == 0) {
					que.add(i);
				}
			}
			while(!que.isEmpty()) {
				Integer node = que.poll();
				tmpRank.add(node+1);
				inDegree[node] = -1;
				if(!que.isEmpty()) {
					question = true;
					break;
				}
				for(int i=0; i<n; i++) {
					if(map[node][i]) {
						inDegree[i]--;
					}
				}
				for(int i=0; i<n; i++) {
					if(inDegree[i] == 0) {
						que.add(i);
					}
				}
			}
			if(question) {
				System.out.println("?");
			}else if(tmpRank.size()<n) {
				System.out.println("IMPOSSIBLE");
			}else {
				for(int i : tmpRank) {
					System.out.print(i+" ");
				}
				System.out.println();
			}
		}
	}
	public static String next() {
		while(!st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			}catch(IOException e) {
				
			}
		}
		return st.nextToken();
	}
	public static int nextInt() {
		return Integer.parseInt(next());
	}
}
