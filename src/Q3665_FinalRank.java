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
			ArrayList<Q3665Node> list = new ArrayList<>();
			ArrayList<Integer> tmpRank = new ArrayList<>();
			boolean question = false;
			int n = nextInt();
			for(int i=0; i<n; i++) {
				tmpRank.add(nextInt()-1);
				list.add(new Q3665Node(i+1));
			}
			for(int i=0; i<n; i++) {
				int tr = tmpRank.get(i);
				for(int j=i+1; j<n; j++) {
					int out = tmpRank.get(j);
					list.get(tr).out.add(list.get(out));
					list.get(out).inCount++;
				}
			}
			int m = nextInt();
			for(int i=0; i<m; i++) {
				int head = nextInt();
				int out = nextInt();
				Q3665Node node = list.get(out-1);
				int idx = -1;
				for(int j=0; j<node.out.size(); j++) {
					if(node.out.get(j).head == head) {
						idx = j;
						break;
					}
				}
				if(idx>=0) {
					list.get(head-1).inCount--;
					list.get(head-1).out.add(node);
					node.out.remove(idx);
				}
				node.inCount++;
			}
			Queue<Q3665Node> que = new LinkedList<>();
			tmpRank.clear();
			for(Q3665Node node : list) {
				if(node.inCount == 0) {
					que.add(node);
				}
			}
			while(!que.isEmpty()) {
				Q3665Node node = que.poll();
				tmpRank.add(node.head);
				if(!que.isEmpty()) {
					question = true;
					break;
				}
				for(int i=0; i<node.out.size(); i++) {
					Q3665Node out = node.out.get(i);
					out.inCount--;
					if(out.inCount == 0) {
						que.add(out);
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
class Q3665Node{
	int head;
	ArrayList<Q3665Node> out;
	int inCount;
	public Q3665Node(int h){
		head = h;
		out = new ArrayList();
		inCount = 0;
	}
}
