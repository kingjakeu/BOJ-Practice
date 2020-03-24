package BAEKJOON.priorityQue;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1655_SayMid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if(o1.compareTo(o2) > 0){
                return -1;
            }else if(o1.compareTo(o2)<0){
                return 1;
            }else{
                return 0;
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(i % 2 == 1){
                if(!minHeap.isEmpty() && (minHeap.peek() < tmp)){
                    int p = minHeap.poll();
                    minHeap.add(tmp);
                    tmp = p;
                }
                maxHeap.add(tmp);
            }else{
                if(!maxHeap.isEmpty()&& maxHeap.peek() > tmp){
                    int p = maxHeap.poll();
                    maxHeap.add(tmp);
                    tmp = p;
                }
                minHeap.add(tmp);
            }
            sb.append(maxHeap.peek());
            if(i != n) sb.append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }
}
