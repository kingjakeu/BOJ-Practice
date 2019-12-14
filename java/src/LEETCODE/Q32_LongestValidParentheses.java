package LEETCODE;

import java.util.Stack;

public class Q32_LongestValidParentheses {
}
class Q32_LongestValidParentheses_Solution {
    public int longestValidParentheses(String s) {
        int leng = s.length();
        Stack<Integer> st = new Stack<>();
        int answer = 0;
        int idx = -1;
        for (int i = 0; i < leng; i++) {
            if(s.charAt(i)=='('){
                st.add(i);
            }else{
                if(st.isEmpty()) idx = i;
                else{
                    st.pop();
                    if(st.isEmpty()) answer = Math.max(answer, i-idx);
                    else answer = Math.max(answer , i-st.peek());
                }
            }
        }
        return answer;
    }
}