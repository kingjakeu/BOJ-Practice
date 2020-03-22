package BAEKJOON.priorityQue;

import java.io.*;
import java.util.PriorityQueue;

public class Q11279_MaxHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.compareTo(o2) < 0){
                return -1;
            }else if(o1.compareTo(o2) > 0){
                return 1;
            }else{
                return 0;
            }
        });


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0){
                if(queue.isEmpty()){
                    bw.write("0");
                }else{
                    bw.write(String.valueOf(queue.poll()));
                }
                bw.newLine();
            }else{
                queue.add(tmp);
            }
        }
        bw.close();
    }
}
