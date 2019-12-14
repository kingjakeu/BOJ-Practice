package LEETCODE;

import java.util.LinkedList;

public class Q34_FindFirstandLastPositionofElementinSortedArray {
}
class Q34_FindFirstandLastPositionofElementinSortedArray_Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = {-1, -1};
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low<=high){
            mid = (high+low)/2;
            if(nums[low] == target && nums[high] == target){
                answer[0] = low;
                answer[1] = high;
                break;
            }
            if(high == low){
                break;
            }
            if(nums[mid]<target){
                low = mid+1;
            }
            if(nums[mid] > target){
                high = mid-1;
            }
            if(nums[mid] == target){
                if(nums[low]<target){
                    low += 1;
                }
                if(nums[high]>target){
                    high -= 1;
                }
            }
        }
        return answer;
    }
}