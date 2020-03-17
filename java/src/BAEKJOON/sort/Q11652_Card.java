package BAEKJOON.sort;

import java.io.*;
import java.util.*;

public class Q11652_Card {
    static long[] result;
    static Map<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        result = new long[n];
        long[] arr = new long[n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            long tmp = Long.parseLong(br.readLine());
            if(map.containsKey(tmp)){
                map.put(tmp, map.remove(tmp)+1);
            }else{
                map.put(tmp, 1);
                arr[idx++] = tmp;
            }
        }
        if(idx <= 1){
            result = arr;
        }else{
            sort(0, idx-1, arr);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result[0]));
        bw.close();
    }

    public static void sort(int low, int high, long[] arr){
        if(low < high){
            int mid = (low + high) / 2;
            sort(low, mid, arr);
            sort(mid+1, high, arr);
            merge(low, mid, high, arr);
        }
    }

    public static void merge(int low, int mid, int high, long[] arr){
        int left = low;
        int right = mid+1;

        for (int i = low; i <= high ; i++) {
            if(left > mid) result[i] = arr[right++];
            else if(right > high) result[i] = arr[left++];
            else{
                int lc = map.get(arr[left]);
                int rc = map.get(arr[right]);
                if(lc > rc){
                    result[i] = arr[left++];
                }else if(lc < rc){
                    result[i] = arr[right++];
                }else{
                    if(arr[left] <= arr[right]){
                        result[i] = arr[left++];
                    }else {
                        result[i] = arr[right++];
                    }
                }
            }
        }
        for (int i = low; i <= high ; i++) {
            arr[i] = result[i];
        }
    }
}
