package LEETCODE.medium.binarySearch;

public class Q162_FindPeakElement {
    class Solution {
        public int findPeakElement(int[] nums) {
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                boolean b = false;
                if(i-1 > 0 && nums[i-1] > nums[i]){
                    b = true;
                }
                if(i+1 < n && nums[i+1] > nums[i]) {
                }else{
                    if(!b) return i;
                    else i +=1;
                }
            }
            return 0;
        }
    }
}
