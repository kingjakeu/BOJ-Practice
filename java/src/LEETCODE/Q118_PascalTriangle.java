package LEETCODE;

import java.util.LinkedList;
import java.util.List;

public class Q118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new LinkedList<>();

        if(numRows > 0){
            List<Integer> tempList = new LinkedList<>();
            tempList.add(1);
            answer.add(tempList);
            for (int i = 1; i < numRows; i++) {
                tempList = new LinkedList<>();
                tempList.add(1);
                for (int j = 1; j < i; j++) {
                    int left = answer.get(i-1).get(j-1);
                    int right = answer.get(i-1).get(j);
                    tempList.add(left+right);
                }
                tempList.add(1);
                answer.add(tempList);
            }
        }
        return answer;
    }
}