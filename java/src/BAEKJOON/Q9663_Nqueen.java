package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663_Nqueen {

    static int count = 0;

    public static void dfs(int idx, int n, int[] map){
        if (idx == n) {
            count += 1;
            return;
        }
        for (int i = 1; i <= n; i++) {
            map[idx+1] = i;
            if (isPromising(idx+1, map)){
                dfs(idx+1, n, map);
            }
        }

    }
    public static boolean isPromising(int idx, int[] map){
        for (int i = 1; i < idx; i++) {
            if(map[i] == map[idx]) return false;
            if(Math.abs(map[i]-map[idx]) == Math.abs(i-idx)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n+1];

        for (int i = 1; i <= n; i++) {
            map[1] = i;
            dfs(1, n, map);
        }

        System.out.println(count);
    }
}
