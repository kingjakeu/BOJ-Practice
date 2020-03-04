package BAEKJOON.sort;

import java.io.*;
import java.util.LinkedList;

public class Q2750_Sort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            int j = 0;
            for (j = 0; j < i; j++) {
                if(list.get(j) > tmp){
                     break;
                }
            }
            list.add(j, tmp);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int a : list){
            bw.write(String.valueOf(a));
            bw.newLine();
        }
        bw.close();
    }
}
