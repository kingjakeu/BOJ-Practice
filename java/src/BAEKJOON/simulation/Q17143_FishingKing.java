package BAEKJOON.simulation;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17143_FishingKing {
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Shark[][] map = new Shark[r][c];

        Queue<Shark> que = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Shark shark = new Shark(i, st);
            map[shark.y][shark.x] = shark;
            que.add(shark);
        }

        int count = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (map[j][i] != null){
                    count += map[j][i].size;
                    map[j][i] = null;
                    break;
                }
            }
            Shark[][] newMap = new Shark[r][c];
            Queue<Shark> newQue = new LinkedList<>();
            while (!que.isEmpty()){
                Shark shark = que.poll();
                if(map[shark.y][shark.x] != null && map[shark.y][shark.x].id == shark.id){
                    shark.move();
                    if(newMap[shark.y][shark.x] == null || (newMap[shark.y][shark.x] != null && newMap[shark.y][shark.x].size < shark.size)){
                        newMap[shark.y][shark.x] = shark;
                        newQue.add(shark);
                    }
                }
            }
            que = newQue;
            map = newMap;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(count));
        bw.close();
    }

    static class Shark {
        int id;
        int x;
        int y;
        int speed;
        int dir;
        int size;

        Shark(int id, StringTokenizer st){
            this.id = id;
            this.y = Integer.parseInt(st.nextToken())-1;
            this.x = Integer.parseInt(st.nextToken())-1;
            this.speed = Integer.parseInt(st.nextToken());
            this.dir = Integer.parseInt(st.nextToken());
            this.size = Integer.parseInt(st.nextToken());
        }

        void move(){
            for (int i = 0; i < speed; i++) {
                if(dir == 1){
                    if(y-1 >= 0) y--;
                    else{
                        y++;
                        dir = 2;
                    }
                }else if(dir == 2){
                    if(y+1 < r) y++;
                    else{
                        y--;
                        dir = 1;
                    }
                }else if(dir == 3){
                    if(x+1 < c) x++;
                    else{
                        x--;
                        dir = 4;
                    }
                }else if(dir == 4){
                    if(x-1 >= 0) x--;
                    else{
                        x++;
                        dir = 3;
                    }
                }
            }
        }
    }
}
