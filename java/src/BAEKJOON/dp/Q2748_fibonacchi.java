package BAEKJOON.dp;

import java.io.*;

public class Q2748_fibonacchi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] cache = new long[n+1];

        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n ; i++) {
            cache[i] = cache[i-2] + cache[i-1];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cache[n]));
        bw.close();
    }
}
