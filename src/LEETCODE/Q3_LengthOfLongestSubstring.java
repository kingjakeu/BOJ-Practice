package LEETCODE;

import java.util.HashSet;
import java.util.Set;
/**
 * LeetCode #3 LengthOfLongestSubstring
 * 2019.07.11
 * @author kingjakeu
 * */
public class Q3_LengthOfLongestSubstring {
}
class SQ3_LengthOfLongestSubstring_Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0, i = 0, j =0, leng = s.length();
        Set<Character> charSet = new HashSet<>();
        while(i < leng && j <leng){
            if(charSet.contains(s.charAt(i))){
                charSet.remove(s.charAt(j));
                j++;
            }else{
                charSet.add(s.charAt(i));
                i++;
                answer = Math.max(answer,i-j);
            }
        }
        return answer;
    }
}