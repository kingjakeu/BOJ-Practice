package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1516_GameDevelopment {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	
	public static void main(String[] args) {
		int n = nextInt();
		ArrayList<Q1516Node> list = new ArrayList();		
		Queue<Q1516Node> que = new LinkedList();
		for(int i=0; i<n; i++) {
			list.add(new Q1516Node(0));
		}
		
		for(int i=0; i<n; i++) {
			int scan = 0;
			scan = nextInt();
			list.get(i).time = scan;
			scan = nextInt();
			while(scan>0) {
				list.get(scan-1).postBuild.add(i);
				list.get(i).count++;
				scan = nextInt();
			}
			if(list.get(i).count == 0) {
				que.add(list.get(i));
			}
		}
			
		while(!que.isEmpty()) {
			Q1516Node node = que.poll();
			for(int post : node.postBuild) {
				Q1516Node postNode = list.get(post);
				postNode.addTime = Math.max(node.time, postNode.addTime);
				postNode.count--;
				if(postNode.count == 0) {
					postNode.time += postNode.addTime;
					que.add(postNode);
				}
			}
		}
		for(int i=0; i<n; i++) {
			System.out.println(list.get(i).time);
		}
	}
	public static String next() {
		while(!st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			}catch(IOException e){
			}
		}
		return st.nextToken();
	}
	public static int nextInt() {
		return Integer.parseInt(next());
	}
}
class Q1516Node{
	int time;
	int addTime;
	ArrayList<Integer> postBuild;
	int count;
	public Q1516Node(int t) {
		time = t;
		addTime = 0;
		postBuild = new ArrayList();
		count = 0;
	}
}
