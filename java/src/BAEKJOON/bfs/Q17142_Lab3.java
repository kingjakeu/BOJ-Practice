package BAEKJOON.bfs;

import java.io.*;
import java.util.*;

public class Q17142_Lab3 {
    static Dot[] vList = new Dot[2501];
    static Dot[] wList = new Dot[2501];
    static int[][] offset = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static int[][] map;
    static int[][] visited;
    static int n;
    static int m;
    static int wCount = 0;
    static int vCount = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

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
        search(new boolean[vCount], 0, m);
        answer = answer == Integer.MAX_VALUE ? -1 : answer;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static void search(boolean[] visit, int start, int r){
        if(r == 0){
            Queue<Dot> newComb = new LinkedList<>();
            visited = new int[n][n];
            for (int i = 0; i < vCount; i++) {
                if(visit[i]) {
                    newComb.add(vList[i]);
                    visited[vList[i].y][vList[i].x] = 1;
                }
            }

            bfs(newComb);
        }
        if(start == vCount) return;
        for (int i = start; i < vCount; i++) {
            visit[i] = true;
            search(visit, i+1 , r-1);
            visit[i] = false;
        }
    }

    static void bfs(Queue<Dot> que){
        int result = 0;
        int wLeft = wCount;
        int tmp = 0;

        while(!que.isEmpty()){
            int queSize = que.size();
            boolean meetZero = false;
            for (int q = 0; q < queSize; q++) {
                Dot dot = que.poll();

                for (int i = 0; i < 4; i++) {
                    int dx = dot.x + offset[i][0];
                    int dy = dot.y + offset[i][1];
                    if(dx >= 0 && dx< n && dy >= 0 && dy < n && visited[dy][dx] == 0 && map[dy][dx] != 1){
                        Dot next = new Dot(dy, dx);
                        visited[dy][dx] = 1;

                        if(map[dy][dx] == 0){
                            meetZero = true;
                            wLeft--;
                        }

                        que.add(next);
                    }
                }
            }
            if(meetZero){
                result += ++tmp;
                tmp = 0;
            }else{
                tmp++;
            }
        }

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
