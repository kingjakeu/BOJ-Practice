package LEETCODE.medium;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Q402_Kdigits {
    class Solution {
        public String removeKdigits(String num, int k) {
            int length = num.length();
            int r = length - k;
            if(r == 0) return "0";

            Deque<Character> stack = new LinkedList<>();
            int stackSize = 1;
            stack.add(num.charAt(0));
            for (int i = 1; i < length; i++) {
                char c = num.charAt(i);

                while(stackSize+length-i > r && stackSize > 0 && stack.getLast() > c){
                    stack.removeLast();
                    stackSize -= 1;
                }
                if(stackSize == 0 || stackSize < r){
                    stack.addLast(c);
                    stackSize++;
                }
            }
            String answer = "";
            while(stackSize > 1){
                char c = stack.removeFirst();
                if(!(answer.equals("") && c == '0')){
                    answer = answer + c;
                }
                stackSize--;
            }
            answer = answer + stack.pop();
            return answer;
        }
    }
}
