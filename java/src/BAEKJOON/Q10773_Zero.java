package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q10773_Zero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                sum -= stack.pollLast();
            }else{
                sum += input;
                stack.add(input);
            }
        }
        System.out.println(sum);
    }
}
