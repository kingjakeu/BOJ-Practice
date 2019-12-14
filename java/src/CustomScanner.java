import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CustomScanner {
	private BufferedReader br;
	private StringTokenizer st;
	
	void init() {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer("");
		
	}
	String readLine() {
		try {
			return br.readLine();
		}catch(IOException e) {
			return null;
		}
	}
	String readLineReplace() {
		try {
			return br.readLine().replaceAll("\\s", "");
		}catch (IOException e) {
			
		}
		return null;
	}
	String next() {
		while(!st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			}catch(IOException e) {
				
			}
		}
		return st.nextToken();
	}
	int nextInt() {
		return Integer.parseInt(next());
	}
	long nextLong() {
		return Long.parseLong(next());
	}
	double nextDouble() {
		return Double.parseDouble(next());
	}

}
