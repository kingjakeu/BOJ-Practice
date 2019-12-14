package LEETCODE;

/**
 * Created by jakeu on 22/07/2019.
 */
public class Q70_ClimbingStairs {
}
class Q70_ClimbingStairs_Solution {
    public int climbStairs(int n) {
        int[] stairs = new int[n+2];
        stairs[0] = 1;
        stairs[1] = 1;
        for(int i = 2; i<=n; i++){
            stairs[i] = stairs[i-2] + stairs[i-1];
        }
        stairs[0] = 0;
        return stairs[n];
    }
}