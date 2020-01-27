package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q1874_StackSeries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        int idx = 1;
        for (int i = 1; i <= n; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if(deque.isEmpty() || deque.peek()<tmp){
                for (int j = idx; j <= tmp ; j++) {
                    deque.push(j);
                    sb.append("+\n");
                }
                deque.pop();
                sb.append("-\n");
                idx = tmp+1;
            }else if (deque.peek() == tmp){
                deque.pop();
                sb.append("-\n");
            }else if(deque.peek() > tmp){
                System.out.println("NO");
                return;
            }
        }
        System.out.print(sb.toString());
    }
}
