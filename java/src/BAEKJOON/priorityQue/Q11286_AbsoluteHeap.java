package BAEKJOON.priorityQue;

import java.io.*;
import java.util.PriorityQueue;

public class Q11286_AbsoluteHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pQue = new PriorityQueue<Long>((x, y)->{
            long abX = Math.abs(x);
            long abY = Math.abs(y);
            if(abX > abY){
                return 1;
            }else if(abX < abY){
                return -1;
            }else{
                if(x < y){
                    return -1;
                }else if(x > y){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            long tmp = Long.parseLong(br.readLine());
            if(tmp == 0){
                Long pop = pQue.poll();
                pop = pop == null ? 0 : pop;
                bw.write(String.valueOf(pop));
                bw.newLine();
            }else{
                pQue.add(tmp);
            }
        }
        bw.close();
    }
}
