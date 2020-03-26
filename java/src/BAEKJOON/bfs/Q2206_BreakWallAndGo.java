package BAEKJOON.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206_BreakWallAndGo {
    static int[][] offset = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static char[][] map;
    static int[][][] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = arr[j];
            }
        }

        Queue<Dot> que = new LinkedList<>();
        visited[0][0][0] = 1;
        que.add(new Dot(0,0, 0));

        while(!que.isEmpty()){
            Dot dot = que.poll();
            for (int i = 0; i < 4; i++) {
                int dx = dot.x + offset[i][0];
                int dy = dot.y + offset[i][1];
                if(dx >= 0 && dx < m && dy >= 0 && dy < n){
                    if(map[dy][dx] == '0' && visited[dy][dx][dot.isWall] == 0){
                        visited[dy][dx][dot.isWall] = visited[dot.y][dot.x][dot.isWall] + 1;
                        que.add(new Dot(dx, dy, dot.isWall));
                    }else if((map[dy][dx] == '1' && dot.isWall == 0) && visited[dy][dx][1] == 0){
                        visited[dy][dx][1] = visited[dot.y][dot.x][dot.isWall] + 1;
                        que.add(new Dot(dx, dy, 1));
                    }
                }
            }
        }
        int result;
        if(visited[n-1][m-1][0] == 0 && visited[n-1][m-1][1] ==0) result = -1;
        else {
            visited[n-1][m-1][0] = visited[n-1][m-1][0] == 0 ? Integer.MAX_VALUE : visited[n-1][m-1][0];
            visited[n-1][m-1][1] = visited[n-1][m-1][1] == 0 ? Integer.MAX_VALUE : visited[n-1][m-1][1];
            result = Math.min(visited[n-1][m-1][0], visited[n-1][m-1][1]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.close();
    }

    static class Dot{
        int x;
        int y;
        int isWall;

        Dot(int x, int y, int b){
            this.x = x;
            this.y = y;
            this.isWall = b;
        }
    }
}
