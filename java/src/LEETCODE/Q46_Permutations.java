package LEETCODE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q46_Permutations {
}
class Q46_Permutations_Solution {
    public List<List<Integer>> answer = new LinkedList<>();
    public void permutation(int pivot, int[] num){
        int leng = num.length;
        if(pivot == leng){
            List<Integer> ans = new LinkedList<>();
            for(int n : num){
                ans.add(n);
            }
            answer.add(ans);
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
    public List<List<Integer>> permute(int[] nums) {
        permutation(0,nums);
        return answer;
    }
}
