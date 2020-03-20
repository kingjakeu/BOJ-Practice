package BAEKJOON.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Q14501_ToiSa {
    static int[] cost;
    static int[] time;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n+1];
        time = new int[n+1];

        int[] cache = new int[n+2];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        cache[0] = 0;

        for (int i = n; i >= 1 ; i--) {
            if(time[i]+i <= n+1){
                cache[i] = Math.max(cost[i]+cache[time[i]+i], cache[i+1]);
            }else{
                cache[i] = cache[i+1];
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cache[1]));
        bw.close();
    }
}
