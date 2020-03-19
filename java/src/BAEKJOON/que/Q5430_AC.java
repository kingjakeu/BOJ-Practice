package BAEKJOON.que;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Q5430_AC {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String commend = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new LinkedList<>();
            boolean reversed = false;
            String rawNums =  br.readLine();
            String[] strNums = rawNums.substring(1, rawNums.length()-1).split(",");
            for(String str : strNums){
                if(!str.equals("")){
                    deque.addLast(Integer.parseInt(str));
                }
            }
            boolean failed = false;
            int length = commend.length();
            for (int i = 0; i < length; i++) {
                char c = commend.charAt(i);
                if(c == 'R'){
                    reversed = !reversed;
                }else if(c == 'D'){
                    Integer poll;
                    if(reversed){
                        poll = deque.pollLast();
                    }else{
                        poll = deque.pollFirst();
                    }
                    if(poll == null){
                        failed = true;
                        break;
                    }
                }
            }
            if(failed){
                bw.write("error");
            }else{
                StringBuilder sb = new StringBuilder("[");
                boolean isEmpty = deque.isEmpty();
                while(!isEmpty){
                    if(reversed){
                        sb.append(deque.pollLast());
                    }else{
                        sb.append(deque.pollFirst());
                    }
                    isEmpty = deque.isEmpty();
                    if(!isEmpty){
                        sb.append(",");
                    }
                }
                sb.append("]");
                bw.write(sb.toString());
            }
            bw.newLine();
        }
        bw.close();
    }
}
