package LEETCODE.medium.dp;

public class Q91_DecodeWays {
    class Solution {
        public int numDecodings(String s) {
            int length = s.length();
            if(length == 0) return 0;
            if(s.charAt(0) == '0') return 0;

            int[] cache = new int[length+1];

            cache[0] = 1;
            cache[1] = s.charAt(0) == '0' ? 0 : 1;
            for (int i = 2; i <=length; i++) {

                int tmp = Integer.parseInt(s.substring(i-2, i));
                if(s.charAt(i-1) == '0'){
                    if(tmp == 10 || tmp == 20){
                        cache[i] = Math.min(cache[i-2], cache[i-1]);
                    }else{
                        cache[i] = 0;
                    }
                }else{
                    if(tmp <= 26 && tmp >= 10){
                        cache[i] = cache[i-2] + cache[i-1];
                    }else{
                        cache[i] = cache[i-1];
                    }
                }
            }
            return cache[length];
        }
    }
}
