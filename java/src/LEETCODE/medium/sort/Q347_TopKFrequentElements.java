package LEETCODE.medium.sort;

import java.util.*;

public class Q347_TopKFrequentElements {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new LinkedList<>();

            for(int num : nums){
                Integer val = map.get(num);
                if(val == null) list.add(num);
                map.put(num, val == null ? 1 : val+1);
            }

            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(map.get(o1) > map.get(o2)) {
                        return -1;
                    }else if(map.get(o1) < map.get(o2)){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            });
            List<Integer> answer = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                answer.add(list.get(i));
            }
            return answer;
        }
    }
}
