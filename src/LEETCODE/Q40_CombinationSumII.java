package LEETCODE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Q40_CombinationSumII {
}
class Q40_CombinationSumII_Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new LinkedList<>();
        HashSet<String> combo = new HashSet<>();
        HashSet<String> ans = new HashSet<>();

        Arrays.sort(candidates);
        int length = candidates.length;

        for (int i = 0; i < length; i++) {
            if(candidates[i]<=target){
                HashSet<String> newCombo = new HashSet<>(combo);
                for (String comStr : combo){
                    int total = candidates[i];
                    String[] tmpArr = comStr.split(" ");
                    for (String s : tmpArr){
                        total += Integer.parseInt(s);
                    }
                    if(total < target){
                        newCombo.add(comStr+candidates[i]+" ");
                    }
                    if(total == target){
                        ans.add(comStr+candidates[i]+" ");
                    }
                }
                combo = newCombo;
                String tmpStr = candidates[i]+" ";
                combo.add(tmpStr);
                if (candidates[i] == target){
                    ans.add(tmpStr);
                }
            }
        }
        for (String s : ans){
            List<Integer> tmpAnswer = new LinkedList<>();
            String[] tmpArr = s.split(" ");
            for (String str : tmpArr){
                tmpAnswer.add(Integer.parseInt(str));
            }
            answer.add(tmpAnswer);
        }
        return answer;
    }
}