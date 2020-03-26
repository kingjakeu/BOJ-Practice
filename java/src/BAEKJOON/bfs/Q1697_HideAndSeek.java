package BAEKJOON.bfs;

import java.io.*;
import java.util.StringTokenizer;

public class Q1697_HideAndSeek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = 100001;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] map = new int[length];

        for (int i = n-1; i >= 0; i--) {
            map[i] = n-i;
        }

        for (int i = 0; i < length; i++) {
            int b = i+1;
            int c = i*2;
            if(b >= 0 && b < length){
                if(map[b] == 0 && b != n){
                    map[b] = map[i]+1;
                }else{
                    map[b] = Math.min(map[i]+1, map[b]);
                }
            }
            if(c >= 0 && c < length){
                if(map[c] == 0 && c != n){
                    map[c] = map[i]+1;
                }else{
                    map[c] = Math.min(map[i]+1, map[c]);
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(map[k]));
        bw.close();
    }
}
