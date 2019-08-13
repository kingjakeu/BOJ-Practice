package LEETCODE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q30_SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"foo","bar"};
        s.findSubstring("barfoothefoobarman", words);
    }
}
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        LinkedList<Integer> answer = new LinkedList<>();
        int wordLeng = words.length;
        if(wordLeng >0){
            int leng = s.length();
            int by = words[0].length();

            for(int i=0; i<leng; i++){
                boolean[] check = new boolean[wordLeng];
                int idx = i;
                for (int j = 0; j < wordLeng; j++) {
                    if(!check[j]){
                        if(idx+by <leng){
                            if(s.substring(idx,idx+by).equals(words[j])){
                                System.out.println(s.substring(idx,idx+by)+" "+words[j]);
                                check[j] = true;
                                idx += by;
                                j = -1;
                            }
                        }
                    }
                }
                boolean nop = false;
                for (boolean b : check){
                    if(!b){
                        nop = true;
                        break;
                    }
                }
                if(!nop){
                    answer.add(i);
                }
            }
        }
        System.out.println(answer.toString());
        return answer;
    }
}