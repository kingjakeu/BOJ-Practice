package BAEKJOON;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Q2164_Card2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }
        int size = n;
        while(size > 1){
            que.poll();
            size--;
            if(size == 1){
                break;
            }
            que.add(que.poll());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(que.peek()));
        bw.close();
    }
}
