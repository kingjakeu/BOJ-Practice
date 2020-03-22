package BAEKJOON.sort;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q7469_KbunZzeSu {
    static Map<Integer, Integer> ogMap = new HashMap<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int callCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            ogMap.put(i, tmp);
            arr[i] = tmp;
        }

        Arrays.sort(arr);

        for (int i = 0; i < callCount; i++) {
            st = new StringTokenizer(br.readLine());
            int low = Integer.parseInt(st.nextToken())-1;
            int high = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken())-1;

            int val = ogMap.get(low+k);
            System.out.println(val);

        }
        bw.close();
    }
}
