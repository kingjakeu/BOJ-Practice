package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15650_NandM {

    public static void dfs(int n, int m, int idx, String str, boolean[] visited){
        if(m == idx) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(" ").append(str.charAt(i));
            }
            System.out.println(sb.toString().substring(1));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                if(idx == 0){
                    dfs(n, m, idx+1, str+i, visited);
                }else{
                    int tmp = str.charAt(idx-1)-48;
                    if(i > tmp){
                        dfs(n, m, idx+1, str+i, visited);
                    }
                }
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
