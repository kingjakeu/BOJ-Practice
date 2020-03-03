package BAEKJOON;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11866_Yosephuthe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }
        String answer = "<";
        int tmp = k;
        while (n > 1){
            if(tmp == 1){
                tmp = k;
                n -= 1;
                answer = answer + que.poll()+", ";
            }else{
                tmp -= 1;
                que.add(que.poll());
            }
        }
        answer = answer + que.poll() + ">";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer);
        bw.close();
    }
}
