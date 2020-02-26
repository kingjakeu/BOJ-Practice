package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Q10828_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] inputs = str.split(" ");

            String op = inputs[0];
            if(op.equals("push")){
                stack.push(Integer.parseInt(inputs[1]));
            }else if(op.equals("pop")){
                try{
                    System.out.println(stack.pop());
                }catch (NoSuchElementException e){
                    System.out.println(-1);
                }
            }else if(op.equals("size")){
                System.out.println(stack.size());
            }else if(op.equals("empty")){
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }else if(op.equals("top")){
                Integer peek = stack.peek();
                if(peek == null) System.out.println(-1);
                else System.out.println(peek);
            }
        }
    }
}
