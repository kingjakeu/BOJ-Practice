package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ #2667 단지번호붙히
 * 분류: BFS
 */ 

public class Q2667_DanjiNum {
	  public static void main(String[] args){
	        CustomScanner cs = new CustomScanner();
	        int n = cs.nextInt();
	        int[][] map = new int[n][n];
	        int[][] off = {{0,1},{0,-1},{1,0},{-1,0}};
	        int count = 1;
	        for(int i=0; i<n; i++) {
	        	String t = cs.readLine();
	        	String[] ts = t.split("");
	        	for(int j=0; j<n; j++) {
	        		map[i][j] = Integer.parseInt(ts[j]);
	        	}
	        }
	        Queue<DanjiNumDOT> que = new LinkedList<>();
	        ArrayList<Integer> ans = new ArrayList<>();
	        
	        for(int i=0; i<n; i++) {
	        	for(int j=0; j<n; j++) {
	        		if(map[i][j] == 1) {
	        			que.add(new DanjiNumDOT(i,j));
	        			count++;
	        			map[i][j] = count;
	        			ans.add(0);
	        			while(!que.isEmpty()) {
	        				DanjiNumDOT d = que.poll();
	        				ans.set(count-2, ans.get(count-2)+1);
	        				
	        				for(int k=0; k<4; k++){
	        					int x = d.x;
	                        	int y = d.y;
	                        	x += off[k][1];
	                            y += off[k][0];
	                            if(y>=0 && y< n && x>=0 &&x<n){
	                                if(map[y][x] == 1){
	                                    map[y][x] = map[d.y][d.x];
	                                    DanjiNumDOT t = new DanjiNumDOT(y,x);
	                                    que.offer(t);
	                                }
	                            }
	        				}
	        			}
	        		}
	        	}
	        }

	        System.out.println(count-1);
	        Collections.sort(ans);
	        for(int q : ans) {
	        	System.out.println(q);
	        }
	        
	    }
	    static class CustomScanner{
	        static BufferedReader br;
	        static StringTokenizer st;
	
	        CustomScanner(){
	            br = new BufferedReader(new InputStreamReader(System.in));
	            st = new StringTokenizer("");   
	        }
	        static String readLine(){
	            try{
	                return br.readLine();
	            }catch(IOException e){
	                return null;
	            }
	        }
	        static String next(){
	            while(!st.hasMoreTokens()){
	                try{
	                    st = new StringTokenizer(br.readLine());
	                }catch(IOException e){
	
	                }
	            }
	            return st.nextToken();
	        }
	        static int nextInt(){
	            return Integer.parseInt(next());
	        }
	    }
}
class DanjiNumDOT{
	int x; 
	int y;
	DanjiNumDOT(int _y, int _x){
		y = _y;
		x = _x;
	}
}
