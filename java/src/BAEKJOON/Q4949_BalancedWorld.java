package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q4949_BalancedWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            int length = str.length();
            if(length == 1 && str.equals(".")) break;

            Deque<Character> deque = new LinkedList<>();
            boolean flag = false;
            for (int i = 0; i < length; i++) {
                if(str.charAt(i) == '(' || str.charAt(i) == '['){
                    deque.push(str.charAt(i));
                }else if(str.charAt(i) == ')' || str.charAt(i) == ']'){
                    if(deque.isEmpty()){
                        flag = true;
                    }else{
                        if(deque.peek() == '(' && str.charAt(i) == ')') deque.pop();
                        else if(deque.peek() == '[' && str.charAt(i) == ']') deque.pop();
                        else flag = true;
                    }
                }
                if(flag){
                    break;
                }
            }
            if(flag || !deque.isEmpty()) System.out.println("no");
            else System.out.println("yes");
        }
    }
}
