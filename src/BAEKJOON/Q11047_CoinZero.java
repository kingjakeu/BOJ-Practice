package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047_CoinZero {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		int idx = 0;
		for(int i=n-1; i>=0; i--) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		while(k != 0 && idx < n) {
			if(k-coin[idx]>=0) {
				k = k - coin[idx];
				count++;
			}else {
				idx++;
			}
		}
		System.out.println(count);
	}
}
