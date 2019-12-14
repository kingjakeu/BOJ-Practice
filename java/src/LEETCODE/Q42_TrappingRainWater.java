package LEETCODE;

import java.util.Stack;

public class Q42_TrappingRainWater {
}
class Q42_TrappingRainWater_Solution {
    public int trap(int[] height) {
        int answer = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int h : height){
            if(h>=max){
                while (!stack.isEmpty()){
                    answer += max - stack.pop();
                }
                max = h;
            }else{
                stack.add(h);
            }
        }
        max  = 0;
        while (!stack.isEmpty()){
            int h = stack.pop();
            if(h>=max){
                max = h;
            }else{
                answer += max-h;
            }
        }
        return answer;
    }
}