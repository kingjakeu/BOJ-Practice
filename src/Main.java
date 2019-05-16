//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.Stack;
//import java.util.StringTokenizer;
//import java.io.IOException;
//
//public class Main {
//
//	public static void main(String[] args) {
//		CustomScanner sc = new CustomScanner();
//		
//		int r = sc.nextInt();
//		int c = sc.nextInt();
//		char[][] map = new char[r][c];
//		int[][] offset = {{1,0},{-1,0},{0,1},{0,-1}};
//		
//		DOT start, end;
//		Queue<DOT> que = new LinkedList<>();
//		
//		for(int i=0; i<r; i++) {
//			String stmp = sc.readLine();
//			for(int j=0; j<c; j++) {
//				map[i][j] = stmp.charAt(j);
//				if(map[i][j] == 'M') {
//					start = new DOT(i,j);
//					que.add(start);
//				}
//				if(map[i][j] =='Z') {
//					end = new DOT(i,j);
//				}
//			}
//		}
//		
//		
//		
//		while(!que.isEmpty()) {
//			
//		}
//		
//	}
//	
//	 static class CustomScanner{
//		 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		 static StringTokenizer st = new StringTokenizer("");
//		 
//		 static String readLine() {
//			 try {
//				 return br.readLine();
//			 }catch(IOException e) {
//				 return null;
//			 }
//		 }
//		 static String next() {
//			 while(!st.hasMoreTokens()) {
//				 try {
//					 st = new StringTokenizer(br.readLine());
//				 }catch(IOException e) {
//					 
//				 }
//			 }
//			 return st.nextToken();
//		 }
//		 static int nextInt() {
//			 return Integer.parseInt(next());
//		 }
//	 }
//}
////class DOT{
////	int y;
////	int x;
////	DOT(int _y, int _x){
////		y= _y;
////		x=_x;
////	}
////}