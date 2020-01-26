package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Q14888_EmbeddingOperator {
    static BigInteger min = new BigInteger("10000000000");
    static BigInteger max = new BigInteger("-10000000000");
    static int n = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] ops = new int[4];
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums, ops, 1, BigInteger.valueOf(nums[0]));
        System.out.println(max.toString());
        System.out.println(min.toString());
    }

    public static void dfs(int[] nums, int[] ops, int idx, BigInteger sum){

        if (idx == n){
            if(min.compareTo(sum)>0) min = sum;
            if(max.compareTo(sum)<0) max = sum;
            return;
        }
        BigInteger tmp = BigInteger.valueOf(nums[idx]);
        if(ops[0] > 0) {
            ops[0] -= 1;
            dfs(nums, ops, idx+1, sum.add(tmp));
            ops[0] += 1;
        }
        if(ops[1] > 0) {
            ops[1] -= 1;
            dfs(nums, ops, idx+1, sum.subtract(tmp));
            ops[1] += 1;
        }
        if(ops[2] > 0) {
            ops[2] -= 1;
            dfs(nums, ops, idx+1, sum.multiply(tmp));
            ops[2] += 1;
        }
        if(ops[3] > 0) {
            ops[3] -= 1;
            dfs(nums, ops, idx+1, sum.divide(tmp));
            ops[3] += 1;
        }
    }
}
