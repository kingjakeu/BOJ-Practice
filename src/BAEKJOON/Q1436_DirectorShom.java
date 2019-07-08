package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1436_DirectorShom {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		int num = 665;
		while(count != n) {
			num++;
			String str = String.valueOf(num);
			if(str.contains("666")) {
				count++;
			}
		}
		System.out.println(num);
	}
}
