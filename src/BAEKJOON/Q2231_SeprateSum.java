package BAEKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * BOJ 
 * 2231번 분해
 * 분류: 브루트포스
 * @author kingjakeu
 * 2019. 07. 05
 * **/
public class Q2231_SeprateSum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 1000000;
		boolean check = false;
		for(int i =1; i<=1000000; i++) {
			int tmpSum = i;
			String tmpStr = String.valueOf(i);
			for(int j=0; j<tmpStr.length(); j++) {
				tmpSum += Integer.valueOf(tmpStr.substring(j, j+1));
			}
			if(tmpSum == n) {
				check = true;
				answer = Math.min(answer, i);
			}
		}
		
		if(check) {
			wr.write(String.valueOf(answer));
		}else {
			wr.write("0");
		}
		wr.close();
	}
}
