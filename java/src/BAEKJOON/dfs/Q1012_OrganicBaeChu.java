package BAEKJOON.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Q1012_OrganicBaeChu {
    static int[][] map;
    static Dot[] dotArr;
    static int[][] offset = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static int m;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc  = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            dotArr = new Dot[k];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
                dotArr[i] = new Dot(x, y);
            }

            int count = 0;
            for (int i = 0; i < k; i++) {
                Dot tmpDot = dotArr[i];
                if(map[tmpDot.y][tmpDot.x] == 1){
                    search(tmpDot.x, tmpDot.y);
                    count++;
                }
            }
            bw.write(String.valueOf(count));
            bw.newLine();
        }
        bw.close();
    }

    static void search(int x, int y){
        map[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int dx = x + offset[i][0];
            int dy = y + offset[i][1];
            if(dx >= 0 && dx < m && dy >= 0 && dy < n){
                if(map[dy][dx] == 1){
                    search(dx, dy);
                }
            }
        }
    }

    static class Dot{
        int x;
        int y;
        Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
