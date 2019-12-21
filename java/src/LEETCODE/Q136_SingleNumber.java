package LEETCODE;

public class Q136_SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            int answer = 0;
            for(int num : nums){
                answer ^= num;
            }
            return answer;
        }
    }
}
