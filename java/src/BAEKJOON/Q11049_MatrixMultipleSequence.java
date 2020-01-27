package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11049_MatrixMultipleSequence {
    static int[] matrix;
    static int[][] mem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        matrix = new int[n+1];
        mem = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i] = Integer.parseInt(st.nextToken());
            matrix[i+1] = Integer.parseInt(st.nextToken());
            Arrays.fill(mem[i], Integer.MAX_VALUE);
        }
        System.out.println(calculate(0, n-1));
    }

    static int calculate(int start, int end){
        if (start == end) return 0;
        if (mem[start][end] != Integer.MAX_VALUE) return mem[start][end];

        for (int i = start; i < end; i++) {
            mem[start][end] = Math.min(mem[start][end], calculate(start, i)+calculate(i+1, end)+matrix[start]*matrix[i+1]*matrix[end+1]);
        }
        return mem[start][end];
    }
}
