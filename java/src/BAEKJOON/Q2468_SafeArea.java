package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ #2468 안전구역 
 * 분류: BFS
 */ 

public class Q2468_SafeArea {
	 public static void main(String[] args){
	    	CustomScanner sc = new CustomScanner();
	    	int n = sc.nextInt();
	    	int[][] map = new int[n][n];
	    	int max = 1;
	    	int maxH = 0;
	    	for(int i=0; i<n; i++) {
	    		for(int j=0; j<n; j++) {
	    			map[i][j] = sc.nextInt();
	    			maxH = Math.max(maxH, map[i][j]);
	    		}
	    	}
	    	
	    	for(int th=1; th<=maxH; th++) {
	    		int count = 1;
	    		int[][] cache = new int[n][n];
	    		Queue<SafeAreaDOT> que = new LinkedList<>();
	    		//인접하다 할수 있는 오프셋 상하좌우 
	    		int[][] off = {{1,0},{-1,0},{0,1},{0,-1}};
	    		
	    		
	    		for(int i=0; i<n; i++) {
	    			for(int j=0; j<n; j++) {
	    				// 방문한적없고 침수 높이보다 높으면 
	    				if(cache[i][j] == 0 && map[i][j]>th) {
	       	    			que.add(new SafeAreaDOT(i,j));
	       	    			cache[i][j] = count++;
	       	    			// 넣고 다음 카운트 증가
	       	    			
	        	    		while(!que.isEmpty()) {
	        	    			SafeAreaDOT d = que.poll();
	        	    			for(int k=0; k<4; k++) {
	        	    				int nx = d.x+off[k][0];
	        	    				int ny = d.y+off[k][1];
	        	    				if(nx>=0 && nx<n && ny>=0 && ny<n) {
	        	    					//인접한 곳으로 기기
	        	    					if(cache[ny][nx] == 0 && map[ny][nx] >th) {
	        	    						cache[ny][nx] = cache[d.y][d.x];
	        	    						que.add(new SafeAreaDOT(ny,nx));
	        	    					}
	        	    				}
	        	    			}
	        	    		}
	    				}
	    	    		
	    			}
	    		}
	    		max = Math.max(max, --count);
	    		
	    	}

			System.out.println(max);
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
	class SafeAreaDOT{
		int x;
		int y;
		SafeAreaDOT(int _y, int _x){
			y = _y;
			x = _x;
		}
		
	}