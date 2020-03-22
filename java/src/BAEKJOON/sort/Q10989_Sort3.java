package BAEKJOON.sort;

import java.io.*;

public class Q10989_Sort3 {
    static int n;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        sort(0, n-1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int a : array){
            bw.write(String.valueOf(a));
            bw.newLine();
        }
        bw.close();
    }

    public static void sort(int low, int high){
        if(low < high){
           int lt = low;
           int gt = high;
           int cmp = array[low];
           int i = low;
           while (i <= gt){
               int tmp = array[i];
               if(cmp < tmp) swap(lt++, i++);
               else if(cmp > tmp) swap(i, gt--);
               else i++;
           }
           sort(low, lt-1);
           sort(gt+1, high);
        }
    }

    public static void swap(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
