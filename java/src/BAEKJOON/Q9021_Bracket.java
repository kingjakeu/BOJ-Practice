package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q9021_Bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] arr = str.toCharArray();
            Deque<Character> deque = new LinkedList<>();
            boolean check = false;
            for(char ch : arr){
                if (ch == '('){
                    deque.add(ch);
                }else if(ch == ')'){
                    if (deque.isEmpty()) {
                        check = true;
                    }else if(deque.peek() == ')'){
                        check = true;
                    }else{
                        deque.pop();
                    }
                }
                if(check) break;
            }
            if(deque.isEmpty() && !check){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
