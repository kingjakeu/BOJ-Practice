package LEETCODE;

import java.util.*;

public class Q56_MergeIntervals {
}
class Q56_MergeIntervals_Solution {
    public int[][] merge(int[][] intervals) {
        int[][] answer;
        int leng = intervals.length;
        if(leng == 0){
            return new int[0][0];
        }else{
            List<int[]> list = new LinkedList<>();
            List<int[]> ans = new LinkedList<>();
            for(int[] tmp : intervals){
                list.add(tmp);
            }
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]<o2[0]){
                        return -1;
                    }else if(o1[0]>o2[0]){
                        return 1;
                    }
                    return 0;
                }
            });
            int min = list.get(0)[0];
            int max = list.get(0)[1];
            for(int[] intvl : list){
                if((intvl[0]<=min || intvl[0]<=max)&&(intvl[1]>=min || intvl[1]>=max)){
                    min = Math.min(intvl[0], min);
                    max = Math.max(intvl[1], max);
                }else{
                    int[] temp = {min,max};
                    ans.add(temp);
                    min = intvl[0];
                    max = intvl[1];
                }
            }
            int[] temp = {min,max};
            ans.add(temp);
            answer = new int[ans.size()][2];
            int count =0;
            for(int[] tmp : ans){
                answer[count] = tmp;
                count +=1;
            }
        }
        return answer;
    }
}