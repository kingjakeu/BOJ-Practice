package LEETCODE;

public class Q55_JumpGame {
}
class Q55_JumpGame_Solution {
    public boolean canJump(int[] nums) {
        int leng = nums.length;
        boolean[] jump = new boolean[leng];
        jump[0] = true;
        for (int i = 0; i < leng-1; i++) {
            if(jump[i]){
                for (int j = i; j <= nums[i]; j++) {
                    jump[i+j] = true;
                }
            }
        }
        return jump[leng-1];
    }
}
