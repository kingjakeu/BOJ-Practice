package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1766_QuestionBook {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	
	public static void main(String[] args) {
		int n = nextInt();
		int m = nextInt();
		ArrayList<Q1766Node> list= new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(new Q1766Node(i+1));
		}
		for(int i=0; i<m; i++) {
			int head = nextInt();
			int out = nextInt();
			list.get(head-1).out.add(list.get(out-1));
			list.get(out-1).in++;
		}
		PriorityQueue<Q1766Node> que = new PriorityQueue<>();
		
		for(Q1766Node node : list) {
			if(node.in == 0) {
				que.add(node);
			}
		}
		while(!que.isEmpty()) {
			Q1766Node node = que.poll();
			System.out.print(node.head);
			for(Q1766Node no : node.out) {
				no.in--;
				if(no.in == 0) {
					que.add(no);
				}
			}
			if(!que.isEmpty()) {
				System.out.print(" ");
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
class Q1766Node implements Comparable<Q1766Node>{
	int head;
	ArrayList<Q1766Node> out;
	int in;
	public Q1766Node(int h){
		head = h;
		out = new ArrayList<>();
		in = 0;
	}
	@Override
	public int compareTo(Q1766Node o) {
		if(this.head<o.head) {
			return -1;
		}else {
			return 1;
		}
	}
}