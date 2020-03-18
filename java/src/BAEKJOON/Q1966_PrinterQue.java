package BAEKJOON;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1966_PrinterQue {
    static Deque<Element> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            deque = new LinkedList<>();

            for (int j = 0; j < n; j++) {
                deque.add(new Element(j, Integer.parseInt(st.nextToken())));
            }

            int count = 1;
            while(count <= n){
                Element e = deque.pollFirst();
                if(search(e)){
                    if(e.key == m){
                        bw.write(String.valueOf(count));
                        bw.newLine();
                        break;
                    }
                    count++;
                }else{
                    deque.add(e);
                }
            }
        }
        bw.close();
    }

    public static boolean search(Element e){
        for (Element d : deque){
            if(d.value > e.value){
                return false;
            }
        }
        return true;
    }

    static class Element{
        int key;
        int value;
        Element(int k, int v){
            key = k;
            value = v;
        }
    }
}
