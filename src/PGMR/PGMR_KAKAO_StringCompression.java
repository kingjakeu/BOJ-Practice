package PGMR;

import java.util.Deque;
import java.util.LinkedList;

public class PGMR_KAKAO_StringCompression {
    public static int solution(String s) {
        int length = s.length();
        int answer = length;

        for(int ws = 1; ws <= length/2; ws++){
            StringBuilder sb = new StringBuilder();
            String buffer = s.substring(0, ws);
            int count = 1;
            int i = 0;
            for (i = ws; i <= length-ws ; i+=ws) {
                String tempBuffer = s.substring(i, i+ws);
                if(buffer.equals(tempBuffer)){
                    count+=1;
                }else{
                    sb.append((count > 1) ? count : "").append(buffer);
                    buffer = tempBuffer;
                    count = 1;
                }
            }
            sb.append((count > 1) ? count : "").append(buffer).append(s.substring(i));
            answer = Math.min(answer,sb.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcdede"));
    }
}
