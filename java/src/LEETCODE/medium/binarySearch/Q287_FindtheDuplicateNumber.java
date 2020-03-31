package LEETCODE.medium.binarySearch;

public class Q287_FindtheDuplicateNumber {
    class Solution {
        int answer = 0;
        public int findDuplicate(int[] nums) {
            int n = nums.length;
            search(0, n, nums);
            return answer;
        }

        public void search(int start, int end, int[] nums){
            if(start < end){
                int mid = (start+end)/2;
                for (int i = 0; i < mid; i++) {
                    if(nums[i] == nums[mid]){
                        answer = nums[mid];
                        return;
                    }
                }
                for (int i = mid+1; i < end; i++) {
                    if(nums[i] == nums[mid]){
                        answer = nums[mid];
                        return;
                    }
                }
                search(start, mid, nums);
                search(mid+1, end, nums);
            }
        }
    }
}
