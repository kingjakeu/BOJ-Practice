package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2630_ColorPaper {
    static int blue = 0;
    static int white = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void divide(int x, int y, int n){
        if(n == 1){
            if(map[y][x] == 1) blue += 1;
            else white += 1;
            return;
        }
        int color = map[y][x];
        for (int i = y; i < n; i++) {
            for (int j = x; j < n; j++) {
                if(color != map[i][j]){
                }
            }
        }
    }
}
