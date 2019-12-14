package LEETCODE;

import java.util.*;

public class Q30_SubstringwithConcatenationofAllWords {
}
class Q30_SubstringwithConcatenationofAllWords_Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        LinkedList<Integer> answer = new LinkedList<>();
        int wordLeng = words.length;
        int leng = s.length();

        if(wordLeng>0 && leng >0){
            int by = words[0].length();
            int max = wordLeng*by;
            HashMap<String, Integer> map = new HashMap<>();
            for(String word : words) {
                map.put(word, map.getOrDefault(word, 0)+1);
            }
            for (int i = 0; i < leng; i++) {
                int idx = i;
                boolean check = false;
                HashMap<String, Integer> tmpMap = new HashMap<>(map);

                for(int j = 0; j<wordLeng; j++){
                    if(idx+by<=leng){
                        String tmpStr = s.substring(idx, idx+by);
                        if(tmpMap.containsKey(tmpStr)){
                            if(tmpMap.get(tmpStr) > 0) {
                                tmpMap.put(tmpStr, tmpMap.get(tmpStr)-1);
                                idx = idx+by;
                            }else{
                                check = true;
                                break;
                            }
                        }else {
                            check = true;
                            break;
                        }
                    }else{
                        check = true;
                        break;
                    }
                }
                if(!check){
                    answer.add(i);
                }
            }
        }
        System.out.println(answer.toString());
        return answer;
    }
}