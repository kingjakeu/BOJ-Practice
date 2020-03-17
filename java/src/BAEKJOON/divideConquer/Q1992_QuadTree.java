package BAEKJOON.divideConquer;

import java.io.*;

public class Q1992_QuadTree {
    static int[][] pic;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pic = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                pic[i][j] = Integer.parseInt(str.substring(j, j+1));
            }

        }

        divide(0, 0, n);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    public static void divide(int x, int y, int n){
        int color = scan(x, y, n);
        if(color >= 0){
            sb.append(color);
            return;
        }
        sb.append("(");

        int halfN = n/2;
        divide(x, y, halfN);
        divide(x+halfN, y, halfN);
        divide(x, y+halfN, halfN);
        divide(x+halfN, y+halfN, halfN);
        sb.append(")");
    }

    public static int scan(int x, int y, int n){
        int ret = pic[y][x];
        for (int i = y; i < y+n; i++) {
            for (int j = x; j < x+n; j++) {
                if(ret != pic[i][j]) return -1;
            }
        }
        return ret;
    }
}
