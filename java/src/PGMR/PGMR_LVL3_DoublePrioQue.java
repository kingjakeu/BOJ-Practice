package PGMR;

import java.util.ArrayList;

public class PGMR_LVL3_DoublePrioQue {
	public static void main(String[] args) {
	}
}
class PGMR_LVL3_DoublePrioQue_Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        ArrayList<Integer> que = new ArrayList();
        
        for(String operation : operations) {
        	String[] op = operation.split(" ");
    		int newNum = Integer.parseInt(op[1]);
    		if(op[0].equals("I")) {
        		int i = 0;
        		for(i=0; i<que.size(); i++) {
        			if(que.get(i) >= newNum) {
        				break;
        			}
        		}
        		que.add(i, newNum);
        	}else if(op[0].equals("D")) {
        		int leng = que.size();
        		if(leng > 0) {
        			if(newNum == -1) {
            			que.remove(0);
            		}else if(newNum == 1){
            			que.remove(leng-1);
            		}
        		}		
        	}
        }
        int finalLeng = que.size();
        if(finalLeng ==0) {
        	answer[0] = 0;
        	answer[1] = 0;
        }else {
        	answer[0] = que.get(finalLeng-1);
        	answer[1] = que.get(0);
        }
        return answer;
    }
}