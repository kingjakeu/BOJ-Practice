package BAEKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * BOJ 
 * 2789번 블랙잭
 * 분류: 브루트포스
 * @author kingjakeu
 * 2019. 07. 05
 * **/
public class Q2789_BlackJack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m  = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] cards = new int[n];
		for(int i=0; i<n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0; 
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					int tmpSum = cards[i]+cards[j]+cards[k];
					if(tmpSum<=m) {
						sum = Math.max(tmpSum, sum);
					}
				}
			}
		}
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		wr.write(String.valueOf(sum));
		wr.close();
	}
}
