package BAEKJOON.bfs;

import java.io.*;
import java.util.*;

public class Q17142_Lab3 {
    static Dot[] vList = new Dot[2501];
    static Dot[] wList = new Dot[2501];
    static int[][] offset = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static int[][] map;
    static int n;
    static int wCount = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        int vCount = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    vList[vCount++] = new Dot(i,j);
                }else if(map[i][j] == 0){
                    wList[wCount++] = new Dot(i,j);
                }
            }
        }
        search(new boolean[vCount], 0, vCount, m);

        answer = answer == Integer.MAX_VALUE ? -1 : answer;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static void search(boolean[] visited, int start, int n, int r){
        if(r == 0){
            Queue<Dot> newComb = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if(visited[i]) newComb.add(vList[i]);
            }
            bfs(newComb);
            return;
        }
        if(start == n) return;
        for (int i = start; i < n; i++) {
            visited[i] = true;
            search(visited, i+1 , n, r-1);
            visited[i] = false;
        }
    }

    static void bfs(Queue<Dot> que){
        int[][] visited = new int[n][n];
        int result = 0;
        int wLeft = wCount;
        while(!que.isEmpty()){
            Dot dot = que.poll();
            result = Math.max(result, visited[dot.y][dot.x]);
            if(result > answer && wLeft == 0){
                return;
            }
            for (int i = 0; i < 4; i++) {
                int dx = dot.x + offset[i][0];
                int dy = dot.y + offset[i][1];
                if(dx >= 0 && dx< n && dy >= 0 && dy < n && visited[dy][dx] == 0 && (map[dy][dx] == 0 || map[dy][dx] == 2)){
                    if(map[dy][dx] == 2){
                        visited[dy][dx] = visited[dot.y][dot.x];
                    }else{
                        visited[dy][dx] = visited[dot.y][dot.x]+1;
                        wLeft--;
                    }
                    que.add(new Dot(dy, dx));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        if(wLeft == 0){
            answer = Math.min(answer, result);
        }
    }

    static class Dot{
        int y;
        int x;
        Dot(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
