import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2252_LineUp {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	
	public static void main(String[] args) {
		int n = nextInt();
		int m = nextInt();
		ArrayList<Q2252Node> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			list.add(new Q2252Node(i+1));
		}
		for(int i=0; i<m; i++) {
			int head = nextInt();
			int node = nextInt();
			list.get(head-1).out.add(list.get(node-1));
			list.get(node-1).in.add(list.get(head-1));
		}
		Queue<Q2252Node> que = new LinkedList<>();
		for(Q2252Node no : list) {
			if(no.in.isEmpty()) {
				que.add(no);
			}
		}
		while(!que.isEmpty()) {
			Q2252Node node = que.poll();
			System.out.print(node.head);
			for(Q2252Node no : node.out) {
				Queue<Q2252Node> tmp = new LinkedList<>();
				for(Q2252Node qn : no.in) {
					if(qn.head == node.head) {
						tmp.add(qn);
					}
				}
				while(!tmp.isEmpty()) {
					no.in.remove(tmp.poll());
				}
				if(no.in.isEmpty()) {
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
class Q2252Node{
	int head;
	ArrayList<Q2252Node> in;
	ArrayList<Q2252Node> out;
	public Q2252Node(int h) {
		head = h;
		in = new ArrayList<>();
		out = new ArrayList<>();
	}
}