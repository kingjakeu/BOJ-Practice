package BAEKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q7568_DungChi {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer("");
		
		int n = Integer.parseInt(br.readLine());
		Q7568DOT[] list = new Q7568DOT[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Q7568DOT(st.nextToken(), st.nextToken());  
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(list[i].w < list[j].w && list[i].h < list[j].h) {
					list[i].rank++;
				}
			}
			wr.write(String.valueOf(list[i].rank)+" ");
		}
		wr.close();
	}
}
class Q7568DOT{
	int w, h, rank;
	public Q7568DOT(String _w, String _h) {
		w = Integer.parseInt(_w);
		h = Integer.parseInt(_h);
		rank = 1;
	}
}