package LEETCODE;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Q47_PermutationsII {
}
class Q47_PermutationsII_Solution {
    public List<List<Integer>> answer = new LinkedList<>();
    public HashSet<String> comb = new HashSet<>();
    public void permutation(int pivot, int[] num){
        int leng = num.length;
        if(pivot == leng){
            List<Integer> ans = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for(int n : num){
                ans.add(n);
                sb.append(n);
            }
            if(!comb.contains(sb.toString())){
                comb.add(sb.toString());
                answer.add(ans);
            }
            return;
        }
        for (int i = pivot; i < leng; i++) {
            swap(num, pivot, i);
            permutation(pivot+1, num);
            swap(num, pivot, i);
        }

    }
    public void swap(int[] arr, int pivot, int idx){
        int temp = arr[idx];
        arr[idx] = arr[pivot];
        arr[pivot] = temp;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        permutation(0,nums);
        return answer;
    }
}