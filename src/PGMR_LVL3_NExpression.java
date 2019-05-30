
public class PGMR_LVL3_NExpression {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(5,12));
	}
}
class Solution {
	static int answer = -1;
	static int[] moreN = new int[9];
	
    public void search(int t,int n, int num, int count){
    	//System.out.println(count+": "+t+" "+n+" "+num);
        if(count > 8){
            return ;
        }
        if(t == num){
        	if(count < answer || answer == -1) {
        		answer = count;
        	}
            return ;
        }
        for(int i=0; i<8; i++){
        	int nOff = moreN[i+1];
        	int countOff = i+1;
        	search(t+nOff, n, num, count+countOff);
        	search(t-nOff, n, num, count+countOff);
        	search(t*nOff, n, num, count+countOff);
            if(t%n ==0) {
            	search(t/nOff, n, num, count+countOff);
            }
        }
    }
    public int solution(int n, int number) {
    	for(int i=0; i<8; i++) {
    		moreN[i+1] = (int) (Math.pow(10, i) * n)+moreN[i];
    	}
        if(answer == 8)
        	answer = -1;
        search(0, n, number, 0);
        return answer;
    }
}