package PGMR;

import java.util.Stack;

public class PGMR_KAKAO_NUM2 {
    public static void main(String[] args) {
        PGMR_KAKAO_NUM2_Solution s = new PGMR_KAKAO_NUM2_Solution();
        System.out.println(s.makeToPerfect(")(())("));
    }
}
class PGMR_KAKAO_NUM2_Solution {
    public String makeToPerfect(String w){
        if(w.equals("")){
            return w;
        }else{
            String[] balStr = balString(w);
            System.out.println(balStr[0]+"/"+balStr[1]);
            if(isValid(balStr[0])){
                return balStr[0]+makeToPerfect(balStr[1]);
            }else{
                return "("+makeToPerfect(balStr[1])+")"+reverse(balStr[0]);
            }
        }
    }
    public String[] balString(String w){
        String[] balStr = {"",""};
        if(isValid(w)){
            balStr[0] = w;
            return balStr;
        }
        if(!w.equals("")){
            int length = w.length();
            Stack<Character> stack = new Stack<>();
            stack.push(w.charAt(0));
            int i;
            for(i=1; i<length; i++){
                if(stack.isEmpty()){
                    break;
                }else{
                    if(stack.peek()==w.charAt(i)){
                        stack.push(w.charAt(i));
                    }else{
                        stack.pop();
                    }
                }
            }
            balStr[0]= w.substring(0,i);
            balStr[1]= w.substring(i,length);
        }
        return balStr;
    }
    public boolean isValid(String u){
        if(!u.equals("")){
            Stack<Character> stack = new Stack<>();
            for(char ch : u.toCharArray()){
                if(ch=='('){
                    stack.push(ch);
                }else{
                    if(stack.isEmpty()){
                        return false;
                    }else{
                        stack.pop();
                    }
                }
            }
            return true;
        }
        return false;
    }
    public String reverse(String u){
        if(!u.equals("")){
            u = u.substring(1,u.length()-1);
            StringBuilder sb = new StringBuilder();
            for(char ch : u.toCharArray()){
                if(ch == '('){
                    sb.append(')');
                }else{
                    sb.append('(');
                }
            }
            return String.valueOf(sb);
        }
        return "";
    }
    public String solution(String p) {
        String answer = "";
        return makeToPerfect(p);
    }
}