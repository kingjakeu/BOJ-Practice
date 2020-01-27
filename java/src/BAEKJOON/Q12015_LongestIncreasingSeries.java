package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12015_LongestIncreasingSeries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n+1];
        int[] mem = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums[1] = Integer.parseInt(st.nextToken());
        mem[1] = nums[1];
        int idx = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if(nums[i] > mem[idx]){
                mem[++idx] = nums[i];
            }else{
                int start = 0;
                int end = idx+1;
                while(start < end){
                    int m = (start+end)/2;
                    if(nums[i] > mem[m]){
                        start = m+1;
                    }else{
                        end = m;
                    }
                }
                mem[end] = nums[i];
            }
        }
        System.out.println(idx);
    }
}
