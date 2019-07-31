package LEETCODE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q18_4Sum {
}
class Q18_4Sum_Solution {

    public boolean isDuplicate(List<List<Integer>> answer, List<Integer> list){
        if(answer.isEmpty()){
            return false;
        }
        for(List<Integer> element : answer){
            boolean check = false;
            for (int m = 0; m < 4; m++) {
                if(!element.get(m).equals(list.get(m))){
                    check = true;
                }
            }
            if (!check){
                return true;
            }
        }
        return false;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int leng = nums.length;
        List<List<Integer>> answer = new LinkedList<>();
        for (int i = 0; i < leng - 3; i++) {
            for (int j = i + 1; j < leng - 2; j++) {
                for (int k = j + 1; k < leng - 1; k++) {
                    for (int l = k + 1; l < leng; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> list = new LinkedList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            if(!isDuplicate(answer,list)){
                                answer.add(list);
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}