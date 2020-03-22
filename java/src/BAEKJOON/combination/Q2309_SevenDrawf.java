package BAEKJOON.combination;

import java.io.*;
import java.util.Arrays;

public class Q2309_SevenDrawf {
    static int[] arr = new int[9];
    static int[] answer = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        findCombination(new int[7], 0, 0 ,0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int a : answer){
            bw.write(String.valueOf(a));
            bw.newLine();
        }
        bw.close();
    }
    public static void findCombination(int[] comb, int idx, int start, int sum){
        if(idx == 7){
            if(sum == 100){
                for (int i = 0; i < 7; i++) {
                    answer[i] = comb[i];
                }
            }
            return;
        }
        for (int i = start; i < 9 && 9-i+1 >= 7-idx; i++) {
            //System.out.println(idx+ " "+i);
            comb[idx] = arr[i];
            findCombination(comb, idx+1, i+1, sum+arr[i]);
        }

    }
}
