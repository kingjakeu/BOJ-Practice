package LEETCODE;

import java.util.*;

class Q128_Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int answer = 0;
        for (int num : nums){
            if(set.remove(num)){
                int count = 1;
                int offset = 1;
                while (set.remove(num-offset)){
                    offset += 1;
                    count += 1;
                }
                offset = 1;
                while(set.remove(num+offset)){
                    offset += 1;
                    count += 1;
                }
                answer = Math.max(count, answer);
            }
        }
        return answer;
    }
}