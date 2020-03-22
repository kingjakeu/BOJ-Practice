package BAEKJOON.sort;

import java.io.*;
import java.util.Arrays;

public class Q2751_Sort2 {

    static int n;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random()*250000);
            bw.write(String.valueOf(array[i]));
        }
        bw.newLine();
        Arrays.sort(array);

        for(int a : array){
            bw.write(String.valueOf(a));
        }
        bw.newLine();
        bw.close();
    }

    public static void sort(int low, int high){
        if(low < high){
            int m = (high+low)/2;
            swap(low, m);
            int j = partition(low, high);
            sort(low, j-1);
            sort(j+1, high);
        }
    }

    public static int partition(int low, int high){
        int i = low;
        int j = high+1;

        while (true){
            while(array[++i] < array[low]){
                if(i == high) break;
            }
            while (array[low] < array[--j]){
                if (j == low) break;
            }
            if(i >= j) break;
            swap(i, j);
        }

        swap(low, j);
        return j;
    }

    public static void swap(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
