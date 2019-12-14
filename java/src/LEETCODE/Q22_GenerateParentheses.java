package LEETCODE;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q22_GenerateParentheses {
}
class Q22_GenerateParentheses_Solution {
    public boolean checkValid(String str){
        Stack<Character> stack = new Stack<>();
        int leng = str.length();
        for (int i=0; i<leng; i++){
            if(str.charAt(i) == '('){
                stack.add('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    public List<String> generateParenthesis(int n) {
        HashSet<String> set = new HashSet<>();
        List<String> list = new LinkedList<>();
        list.add("(");
        list.add(")");
        for (int i = 1; i<n*2; i++){
            String left = "(";
            String right = ")";
            List<String> prelist = new LinkedList<>();
            prelist.addAll(list);
            list = new LinkedList<>();
            for(String str : prelist){
                list.add(str+left);
                list.add(str+right);
            }
        }
        for(String str : list){
            if(checkValid(str)){
                set.add(str);
            }
        }
        list = new LinkedList<>();
        list.addAll(set);
        for(String s : list){
            System.out.println(s);
        }
        return list;
    }
}