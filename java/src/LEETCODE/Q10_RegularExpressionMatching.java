package LEETCODE;
/**
 * LEETCODE
 * Q10 Q10_RegularExpressionMatching
 * @author jakeyoo
 * */

public class Q10_RegularExpressionMatching {
}
class Q10_RegularExpressionMatching_Solution {
    public boolean isMatch(String s, String p) {
        boolean answer = false;
        String pa = "^";
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) != '*'){
                pa = pa + "(" + p.charAt(i) + ")";
            }else{
                pa = pa + p.charAt(i);
            }
        }
        pa = pa+"$";
        System.out.println(pa);
        if(s.matches(pa)){
            return true;
        }else{
            return false;
        }
    }
}