package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649_NandM {

    public static void dfs(int n, int m, int idx, String str, boolean visited[]){
        if(m == idx) {
            System.out.println(str.substring(0, m*2-1));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(n, m, idx+1, str+i+" ", visited);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dfs(n, m, 0, "", new boolean[10]);
    }
}
