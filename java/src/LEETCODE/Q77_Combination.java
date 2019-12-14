package LEETCODE;

import java.util.LinkedList;
import java.util.List;

public class Q77_Combination {
}
class Q77_Combination_Solution {
    List<List<Integer>> answer = new LinkedList<>();

    public void combi(int[] arr, int idx, int n, int k, int target){
        if(k == 0){
            List<Integer> ans = new LinkedList<>();
            for (int i = 0; i < idx; i++) {
                ans.add(arr[i]);
            }
            answer.add(ans);
        }else if(target == n){
            return;
        }else{
            arr[idx] = target;
            combi(arr,idx+1,n,k-1,target+1);
            combi(arr, idx, n, k, target+1);
        }

    }
    public List<List<Integer>> combine(int n, int k) {
        int arr[] = new int[n];
        combi(arr,0,n+1,k,1);
        return answer;
    }
}