package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16235_Namu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] energy = new int[n][n];
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                energy[i][j] = 5;
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Map<String, LinkedList<Integer>> trees = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            String key = x + " "+y;
            LinkedList<Integer> list;
            if(trees.containsKey(key)){
                list = trees.get(key);
            }else{
                list = new LinkedList<>();
            }
            list.add(year);
            Collections.sort(list);
            trees.put(key, list);
        }

        for (int i = 0; i < k; i++) {
            for (Map.Entry<String, LinkedList<Integer>> entry : trees.entrySet()){

            }
        }
    }
}
