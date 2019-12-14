package LEETCODE;

import java.lang.reflect.Array;
import java.util.*;

public class Q49_GroupAnagrams {
}
class Q49_GroupAnagrams_Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        int totalLeng = strs.length;
        boolean[] used = new boolean[totalLeng];
        for (int i = 0; i < totalLeng; i++) {
            if(!used[i]){
                List<String> ans = new ArrayList<>();
                ans.add(strs[i]);
                used[i] = true;
                int strLeng = strs[i].length();
                for (int j = i+1; j < totalLeng; j++) {
                    if(!used[j]){
                        int tempLeng = strs[j].length();
                        if(strLeng == tempLeng){
                            List<Character> tempList = new LinkedList<>();
                            for(char c : strs[i].toCharArray()){
                                tempList.add(c);
                            }
                            for (int k = 0; k < tempLeng; k++) {
                                if(tempList.contains(strs[j].charAt(k))){
                                    Character ch= strs[j].charAt(k);
                                    tempList.remove(ch);
                                }
                            }
                            if(tempList.isEmpty()){
                                ans.add(strs[j]);
                                used[j] = true;
                            }
                        }
                    }
                }
                answer.add(ans);
            }
        }

        return answer;
    }
}