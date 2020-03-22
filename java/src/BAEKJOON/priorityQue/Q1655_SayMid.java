package BAEKJOON.priorityQue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1655_SayMid {
    static int[] arr;
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            insert(Integer.parseInt(br.readLine()));
            if(i%2 == 1){
                System.out.println(arr[idx/2 +1]);
            }else{
                System.out.println(Math.min(arr[idx/2], arr[idx/2 + 1]));
            }
        }
    }

    public static void insert(int i){
        arr[++idx] = i;
        swim(idx);
    }

    public static void swim(int k){
        while(k > 1 && arr[k/2] > arr[k]){
            swap(k/2, k);
            k = k/2;
        }
    }

    public static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
