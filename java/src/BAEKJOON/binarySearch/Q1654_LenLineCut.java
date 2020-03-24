package BAEKJOON.binarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class Q1654_LenLineCut {
    static int n;
    static long[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        lines = new long[k];
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <k ; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(search(0, 2147483647)));
        bw.close();

    }

    public static long search(long low, long high){
        while(low <= high){
            long mid = (low+high)/2;
            int sum = 0;
            for(long line : lines){
                sum += line/mid;
            }

            if(sum < n){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
}
