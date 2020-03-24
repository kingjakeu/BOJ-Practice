package BAEKJOON.binarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class Q2805_TreeCut {
    static long[] trees;
    static long m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        trees = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(search(0, Long.MAX_VALUE)));
        bw.close();
    }

    public static long search(long low, long high){
        while(low <= high){
            long mid = (low+high)/2;

            long sum = 0;
            for (long tree : trees){
                long tmp = tree-mid;
                if (tmp > 0) sum += tmp;
            }

            if(sum < m){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return high;
    }
}
