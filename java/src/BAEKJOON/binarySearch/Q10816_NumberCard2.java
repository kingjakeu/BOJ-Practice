package BAEKJOON.binarySearch;

import java.io.*;
import java.util.*;

public class Q10816_NumberCard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String key = st.nextToken();
            int value = Optional.ofNullable(map.get(key)).map(v -> v+1).orElse(1);
            map.put(key, value);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            int value = Optional.ofNullable(map.get(st.nextToken())).orElse(0);
            bw.write(String.valueOf(value));
            if(i<m-1) bw.write(" ");
        }
        bw.close();

    }
}
