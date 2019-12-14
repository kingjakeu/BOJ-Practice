package BAEKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 백준 11399번 ATM
 * 분류 : 그리디
 * */
public class Q11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] times = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(times);
		int total = times[0];
		for(int i=1; i<n; i++) {
			times[i] = times[i]+times[i-1];
			total = total+times[i];
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(total));
		bw.close();
	}
}
