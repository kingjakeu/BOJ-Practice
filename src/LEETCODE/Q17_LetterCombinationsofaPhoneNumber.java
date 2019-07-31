package LEETCODE;

import java.util.LinkedList;
import java.util.List;

public class Q17_LetterCombinationsofaPhoneNumber {
}
class Q17_LetterCombinationsofaPhoneNumber_Solution {
    public List<String> perm(List<String> combo, char[] range){
        List<String> newCombo = new LinkedList<>();
        if(combo.isEmpty()){
            combo.add("");
        }
        int r = range[range.length-1]-range[0]+1;
        String[] arr = new String[r];

        for (int i = 0; i < r; i++) {
            int c = range[0]+i;
            arr[i] = Character.toString((char)c);
        }
        for(String str : combo){
            for(int i=0; i<r; i++){
                StringBuilder sb = new StringBuilder(str);
                newCombo.add(sb.append(arr[i]).toString());
            }
        }
        return newCombo;
    }
    public List<String> letterCombinations(String digits) {
        List<String> answer = new LinkedList<>();
        char[][] range = {{'a','c'},{'d','f'},{'g','i'},{'j','l'},
                {'m','o'},{'p','s'},{'t','v'},{'w','z'}};
        int leng = digits.length();
        for (int i = 0; i < leng; i++) {
            int dig = Integer.valueOf(digits.substring(i,i+1));
            answer = perm(answer,range[dig-2]);
        }
        return answer;
    }
}