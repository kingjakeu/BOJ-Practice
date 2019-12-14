package LEETCODE;

import java.util.LinkedList;
import java.util.List;

public class Q93_RestoreIPAddresses {
}
class Q93_RestoreIPAddresses_Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new LinkedList<>();
        backTrack(s,0,0,new StringBuilder(),s.length(),answer);
        return answer;
    }
    public void backTrack(String s, int idx, int lvl, StringBuilder sb, int length, List<String> answer){
        if(length < idx || lvl>4) return;
        if(length == idx && lvl == 4){
            answer.add(String.valueOf(sb));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if(idx+i > length) break;
            int tmp = Integer.parseInt(s.substring(idx,idx+i));
            if(i==1 || (i==2 && tmp>=10 && tmp<=99) || (i==3 && tmp>=100 && tmp <=255)){
                StringBuilder newSb = new StringBuilder(sb.toString()).append(s.substring(idx, idx+i));
                if(lvl<3){
                    newSb.append(".");
                }
                backTrack(s, idx+i, lvl+1, newSb, length, answer);
            }
        }
    }
}
