package LEETCODE;

public class Q5_LongestPalindromicSubstring {
}
class Q5_LongestPalindromicSubstring_Solution {
    public String longestPalindrome(String text) {
        String palindrome = "";
        int length = text.length();
        boolean[][] dp = new boolean[length][length];
        for (int s = length - 1; s > -1; s--) {
            for (int e = s; e < length; e++) {
                if (s == e || (s + 1 == e && text.charAt(s) == text.charAt(e)))
                    dp[s][e] = true;
                else
                    dp[s][e] = dp[s + 1][e - 1] && text.charAt(s) == text.charAt(e);
                if (dp[s][e] && palindrome.length() < e - s + 1)
                    palindrome = text.substring(s, e + 1);
            }
        }
        return palindrome;
    }
}