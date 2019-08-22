package LEETCODE;

public class Q45_JumpGameII {
}
class Q45_JumpGameII_Solution {
    public int jump(int[] nums) {
        int leng = nums.length;
        if (leng > 0) {
            int[] cache = new int[leng];
            cache[0] = 0;
            for(int i=0; i<leng; i++){
                for (int j = 1; j < nums[i]+1; j++) {
                    if(i+j<leng){
                        if(cache[i+j] == 0){
                            cache[i+j] = cache[i]+1;
                        }else{
                            cache[i+j] = Math.min(cache[i]+1,cache[i+j]);
                        }
                    }
                }
            }
            return cache[leng-1];
        }

        return 0;
    }
}