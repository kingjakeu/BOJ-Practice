package LEETCODE;

import java.util.*;

public class Q39_CombinationSum {
}
class Q39_CombinationSum_Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new LinkedList<>();
        Queue<Q39_Combo> que = new LinkedList<>();
        for (int i : candidates){
            List<Integer> com = new LinkedList<>();
            com.add(i);
            que.add(new Q39_Combo(i,com));
        }
        while (!que.isEmpty()){
            Q39_Combo combo = que.poll();
            if(combo.value == target){
                Collections.sort(combo.list);
                String comboList = combo.list.toString();
                boolean check = false;
                for (List<Integer> el : answer){
                    String elStr = el.toString();
                    if(elStr.equals(comboList)){
                        check = true;
                    }
                }
                if(!check){
                    answer.add(combo.list);
                }
            }else if(combo.value < target){
                for(int can : candidates){
                    Q39_Combo newCombo = new Q39_Combo(combo.value, combo.list);
                    newCombo.value += can;
                    if(newCombo.value <= target){
                        newCombo.list.add(can);
                        que.add(newCombo);
                    }
                }
            }
        }
        return answer;
    }
}
class Q39_Combo{
    List<Integer> list = new LinkedList<>();
    int value;
    Q39_Combo(int v, List<Integer> l){
        list.addAll(l);
        value = v;
    }
}