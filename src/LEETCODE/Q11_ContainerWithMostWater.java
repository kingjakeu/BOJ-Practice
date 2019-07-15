package LEETCODE;
/**
 * LeetCode #11 ContainerWithMostWater
 * 2019.07.15
 * @author kingjakeu
 * */

public class Q11_ContainerWithMostWater {
}
class Q11_ContainerWithMostWater_Solution {
    public int maxArea(int[] height) {
        int leng = height.length;
        int answer = 0;

        for (int i = 0; i < leng; i++) {
            int tempMax = 0, smaller = 0;
            for (int j = 0; j<i; j++){
                if(height[i] > height[j]){
                    smaller = Math.min(height[i], height[j]);
                    tempMax = Math.max(tempMax, smaller*(i-j));
                }
            }
            for (int j = i+1; j < leng; j++) {
                smaller = Math.min(height[i], height[j]);
                tempMax = Math.max(tempMax, smaller*(j-i));
            }
            answer = Math.max(answer,tempMax);
        }
        return answer;
    }
}
