package LEETCODE;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

public class Q8_StringtoInteger {
}
class Q8_StringtoInteger_Solution {
    public int myAtoi(String str) {
        int leng = str.length();
        Queue<Character> que = new LinkedList<>();

        for (int i = 0; i < leng; i++) {
            char tmpChr = str.charAt(i);
            if(tmpChr < '0' || tmpChr>'9'){
                if(!que.isEmpty()){
                    break;
                }
                if(tmpChr == '-' || tmpChr == '+') {
                    que.add(tmpChr);
                }else if(tmpChr != ' '){
                    break;
                }

            }else{
                que.add(tmpChr);
            }
        }
        if(que.isEmpty()){
            return 0;
        }
        if(que.size() == 1){
            if(que.peek() < '0' || que.peek()>'9'){
                return 0;
            }
        }
        String s = "";
        while(!que.isEmpty()){
            s += que.poll();
        }
        BigDecimal result = new BigDecimal(s);
        int num = 0;
        if(result.compareTo(new BigDecimal(String.valueOf(Integer.MAX_VALUE))) == 1){
            num = Integer.MAX_VALUE;
        }else if(result.compareTo(new BigDecimal(String.valueOf(Integer.MIN_VALUE))) == -1){
            num = Integer.MIN_VALUE;
        }else{
            num = Integer.valueOf(s);
        }
        return num;
    }
}