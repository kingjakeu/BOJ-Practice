package BAEKJOON.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697_HideAndSeek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = 100001;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] map = new int[length];

        Queue<Integer> que = new LinkedList<>();
        que.add(n);

        while(!que.isEmpty()){
            int tmp = que.poll();
            if(tmp != k){
                int a = tmp-1;
                int b = tmp+1;
                int c = tmp*2;
                if(a >= 0 && a < length){
                    if(map[a] == 0 && a != n){
                        map[a] = map[tmp]+1;
                        que.add(a);
                    }else if(map[tmp]+1 < map[a]){
                        map[a] = map[tmp]+1;
                        que.add(a);
                    }
                }
                if(b >= 0 && b < length){
                    if(map[b] == 0 && b != n){
                        map[b] = map[tmp]+1;
                        que.add(b);
                    }else if(map[tmp]+1 < map[b]){
                        map[b] = map[tmp]+1;
                        que.add(b);
                    }
                }
                if(c >= 0 && c < length){
                    if(map[c] == 0 && c != n){
                        map[c] = map[tmp]+1;
                        que.add(c);
                    }else if(map[tmp]+1 < map[c]){
                        map[c] = map[tmp]+1;
                        que.add(c);
                    }
                }
            }
        }

        bw.write(String.valueOf(map[k]));
        bw.close();
    }
}
