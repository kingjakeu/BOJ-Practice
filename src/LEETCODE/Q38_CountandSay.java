package LEETCODE;
class Q38_CountandSay_Solution {
    public String countAndSay(int n) {
    	String[] nums = new String[31];
    	nums[1] = "1";
        for(int i=2; i<=n; i++) {
        	nums[i] = "";
        	int preNum = nums[i-1].charAt(0) - '0';
        	int count = 1;
        	for(int j=1; j<nums[i-1].length(); j++) {
        		int tmpNum = nums[i-1].charAt(j) - '0';
        		if(tmpNum == preNum) {
        			count++;
        		}else {
        			nums[i] = nums[i] +String.valueOf(count)+ String.valueOf(preNum);
        			count = 1;
        			preNum = tmpNum;
        		}
        	}
        	nums[i] = nums[i] +String.valueOf(count)+ String.valueOf(preNum);
        }
        return nums[n];
    }
}
public class Q38_CountandSay {
}
