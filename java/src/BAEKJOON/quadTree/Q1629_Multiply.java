package BAEKJOON.quadTree;

import java.io.*;
import java.util.StringTokenizer;

public class Q1629_Multiply {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(divide(a, b, c));
    }

    public static long divide(int a, int b, int c){
        if(b == 1) return a%c;

        long tmp = divide(a, b/2, c);
        long ret = (tmp*tmp) % c;

        if(b%2 == 0){
            return ret;
        }else {
            return (ret * divide(a, 1, c)) % c;
        }
    }
}

