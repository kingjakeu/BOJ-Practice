package BAEKJOON.mockTest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class StickerPut {
    static int[][] map;
    static int answer = 0;
    static int yMax;
    static int xMax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        yMax = Integer.parseInt(st.nextToken());
        xMax = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[yMax][xMax];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            Sticker sticker = new Sticker(y, x);
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < x; l++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if(tmp == 1 ){
                        sticker.list.add(new Dot(j, l));
                        sticker.size++;
                    }
                }
            }
            search(sticker);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.close();
    }

    public static void search(Sticker s){
        for (int r = 0; r < 4; r++) {
            for (int i = 0; i < yMax; i++) {
                for (int j = 0; j < xMax; j++) {
                    if(isFit(s, i, j)){
                        answer += s.size;
                        fill(s, i, j);
                        return;
                    }
                }
            }
            if(r < 3)s.turn();
        }
    }

    public static boolean isFit(Sticker s, int y, int x){
        for(Dot d : s.list){
            int dy = y+d.y;
            int dx = x+d.x;
            if(dy < yMax && dx < xMax){
                if(map[dy][dx] != 0) return false;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void fill(Sticker s, int y, int x){
        for(Dot d : s.list){
            int dy = y+d.y;
            int dx = x+d.x;
            map[dy][dx] = 1;
        }

    }

    static class Sticker{
        int y;
        int x;
        PriorityQueue<Dot> list;
        int size;

        Sticker(int y, int x){
            this.y = y;
            this.x = x;
            this.size = 0;
            list = new PriorityQueue<>(new Comparator<Dot>() {
                @Override
                public int compare(Dot d1, Dot d2) {
                    if(d1.y > d2.y){
                        return 1;
                    }else if(d1.y < d2.y){
                        return -1;
                    }else{
                        if(d1.x > d2.x){
                            return 1;
                        }else if(d1.x < d2.x){
                            return -1;
                        }else{
                            return 0;
                        }
                    }
                }
            });
        }

        void turn(){
            PriorityQueue<Dot> newList = new PriorityQueue<>(new Comparator<Dot>() {
                @Override
                public int compare(Dot d1, Dot d2) {
                    if(d1.y > d2.y){
                        return 1;
                    }else if(d1.y < d2.y){
                        return -1;
                    }else{
                        if(d1.x > d2.x){
                            return 1;
                        }else if(d1.x < d2.x){
                            return -1;
                        }else{
                            return 0;
                        }
                    }
                }
            });
            for(Dot d : list){
                newList.add(new Dot(d.x, y-d.y-1));
            }

            list = newList;
            int t = y;
            y = x;
            x = t;
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
