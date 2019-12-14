package LEETCODE;

public class Q16_3SumClosest {
}
class Q16_3SumClosest_Solution {
    public int threeSumClosest(int[] nums, int target) {
        int answer = 0;
        int diff = Integer.MAX_VALUE;
        int leng = nums.length;
        for (int i = 0; i < leng-2; i++) {
            for (int j = i+1; j < leng-1; j++) {
                for (int k = j+1; k < leng; k++) {
                    int tempSum = nums[i]+nums[j]+nums[k];
                    int absTarget = Math.abs(target);
                    int absSum = Math.abs(tempSum);
                    int tempDiff = 0;

                    if(tempSum < 0 && target < 0) {
                        tempDiff = Math.abs(absTarget-absSum);
                    }else if(tempSum < 0 && target >0) {
                        tempDiff = Math.abs(absTarget+absSum);
                    }else if(tempSum >0 && target <0) {
                        tempDiff = Math.abs(absSum+absTarget);
                    }else if(tempSum > 0 && target > 0){
                        tempDiff = Math.abs(absTarget-absSum);
                    }else{
                        tempDiff = Math.abs(absTarget-absSum);
                    }
                    if(tempDiff<diff){
                        diff = tempDiff;
                        answer = tempSum;
                    }
                }
            }
        }
        return answer;
    }
}