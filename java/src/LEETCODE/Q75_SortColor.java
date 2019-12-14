package LEETCODE;

public class Q75_SortColor {
}
class Q75_SortColor_Solution {
    public void sortColors(int[] nums) {
        int length = nums.length;
        int[] color = {0, 0, 0};
        for(int n : nums){
            if(n==0){
                color[0] += 1;
            }else if(n == 1){
                color[1] += 1;
            }else if(n == 2){
                color[2] += 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < color[i]; j++) {
                nums[i+j] = j;
            }
        }
    }
}