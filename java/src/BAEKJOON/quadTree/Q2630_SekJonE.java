package BAEKJOON.quadTree;

import java.io.*;
import java.util.StringTokenizer;

public class Q2630_SekJonE {
    static int[][] paper;
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(white));
        bw.newLine();
        bw.write(String.valueOf(blue));
        bw.close();
    }

    public static void divide(int x, int y, int offset){
        if(scan(x, y, offset)){
            if(paper[y][x] == 0){
                white += 1;
            }else{
                blue += 1;
            }
            return;
        }

        int newOffset = offset/2;
        divide(x, y, newOffset);
        divide(x+newOffset, y, newOffset);
        divide(x, y+newOffset, newOffset);
        divide(x+newOffset, y+newOffset, newOffset);
    }

    public static boolean scan(int x, int y, int offset){
        int color = paper[y][x];
        for (int i = y; i < y+offset; i++) {
            for (int j = x; j < x+offset; j++) {
                if(color != paper[i][j]) return false;
            }
        }
        return true;
    }
}
