package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

public class Q13458_SihumGamDok {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] rooms = new int[n];
        for (int i = 0; i < n; i++) {
            rooms[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long sum = 0;
        for (int i = 0; i < n; i++) {
            rooms[i] -= b;
            if(rooms[i] < 0) rooms[i] = 0;
            int tmp = rooms[i] > 0 ? rooms[i]/c : 0;
            sum += rooms[i] % c == 0 ? tmp+1 : tmp+2;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sum));
        bw.close();
    }
}
