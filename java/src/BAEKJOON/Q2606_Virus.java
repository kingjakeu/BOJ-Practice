package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ #2606 바이러
 * 분류: BFS
 */ 

public class Q2606_Virus {
	  public static void main(String[] args){
	        CustomScanner cs = new CustomScanner();
	        int n = cs.nextInt();
	        int t = cs.nextInt();
	        int answer = 0;
	        int[] cache = new int[n];
	        int[][] map = new int[n][n];
	        for(int i=0; i<t; i++){
	            int from = cs.nextInt();
	            int to = cs.nextInt();
	            map[from-1][to-1] = 1;
	            map[to-1][from-1] = 1;
	        }
	        Queue<Integer> que = new LinkedList<>();
	        que.offer(0);
	        map[0][0] = 1;
	        while(!que.isEmpty()){
	            int k = que.poll();
	            //print(cache);
	            cache[k] = 1;
	            for(int i=0; i<n; i++){
	                if(map[k][i] == 1){
	                	if(cache[i] == 0) {
	                        que.offer(i);
	                	}
	                }
	            }
	        }
	        for(int i=1; i<n; i++) {
	        	answer += cache[i];
	        }
	        System.out.println(answer);
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

