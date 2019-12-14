package LEETCODE;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Q57_InsertInterval {
}
class Q57_InsertInterval_Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] answer;
        List<int[]> tempAnswer = new LinkedList<>();

        int min = newInterval[0];
        int max = newInterval[1];

        for(int[] intvl : intervals){
            if((intvl[0]<=min || intvl[0]<=max)&&(intvl[1]>=min || intvl[1]>=max)){
                min = Math.min(intvl[0], min);
                max = Math.max(intvl[1], max);
            }else{
                tempAnswer.add(intvl);
            }
        }
        int[] ans = {min,max};
        tempAnswer.add(ans);

        int size = tempAnswer.size();
        answer = new int[size][2];
        tempAnswer.sort((o1, o2) -> {
            if(o1[0]<o2[0]){
                return -1;
            }else if(o1[0]>o2[0]){
                return 1;
            }
            return 0;
        });
        int i = 0;
        for(int[] tmp : tempAnswer){
            answer[i] = tmp;
            i++;
        }
        return answer;
    }
}