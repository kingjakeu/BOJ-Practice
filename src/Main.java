import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		String s;
		try {
			s  = br.readLine();
			int n = Integer.parseInt(s);
			for(int i=0; i<n; i++) {
				s  = br.readLine();
				String[] str = s.split(" ");
				int loop = Integer.parseInt(str[0]);
				String ans = "";
				for(int j=0; j<str[1].length(); j++) {
					for(int k=0; k<loop; k++) {
						ans = ans + str[1].charAt(j);
					}
				}
				bw.write(ans+"\n");
			}
			bw.flush();
		} catch (IOException e) {
		}
	}
}
