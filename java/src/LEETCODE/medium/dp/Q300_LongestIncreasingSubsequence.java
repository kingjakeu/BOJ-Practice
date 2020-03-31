package LEETCODE.medium.dp;

import java.util.Arrays;

public class Q300_LongestIncreasingSubsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] cache = new int[n];
            int lastIdx = 0;
            if(n == 0) return 0;

            cache[0] = nums[0];
            for (int i = 1; i < n; i++) {
                boolean check = false;
                for (int j = 0; j <= lastIdx; j++) {
                    if(cache[j] >= nums[i]){
                        cache[j] = nums[i];
                        check = true;
                        j = i;
                    }
                }
                if(!check) cache[++lastIdx] = nums[i];
            }
            return lastIdx;
        }
    }
}
