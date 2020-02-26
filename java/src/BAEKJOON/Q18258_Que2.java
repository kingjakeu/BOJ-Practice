package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

public class Q18258_Que2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] que = new String[n];
        int front = 0;
        int back = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push")){
                que[back++] = st.nextToken();
            }else{
                if(op.equals("pop")){
                    if(front == back) bw.write("-1");
                    else bw.write(que[front++]);
                }else if(op.equals("size")){
                    bw.write(back - front > 0 ? String.valueOf(back-front) : "0");
                }else if(op.equals("empty")){
                    if(front == back) bw.write("1");
                    else bw.write("0");
                }else if(op.equals("front")){
                    if(front == back) bw.write("-1");
                    else bw.write(que[front]);
                }else if(op.equals("back")){
                    if(front == back) bw.write("-1");
                    else bw.write(que[back-1]);
                }
                bw.newLine();
            }
        }
        bw.close();
    }
}
