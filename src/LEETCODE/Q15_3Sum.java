package LEETCODE;

import java.util.*;

public class Q15_3Sum {
    public static void main(String[] args) {

    }
}
class Q15_3Sum_Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        int leng = nums.length - 2;
        Arrays.sort(nums);
        for (int i = 0; i < leng; i++) {
            int left = i+1;
            int right = leng+1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> ans = new LinkedList<>();
                    ans.add(nums[i]); ans.add(nums[left]); ans.add(nums[right]);
                    answer.add(ans);
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
            while(i<leng && nums[i]==nums[i+1]){
                i++;
            }
        }
        for(List<Integer> ans : answer){
            System.out.println(ans.toString());
        }
        return answer;
    }
}