package BAEKJOON;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Q1157_StudyWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] arr = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(char c : arr){
            if(c >= 97 && c <=122){
                c -= 32;
            }
            if (map.containsKey(c)){
                map.put(c, map.remove(c)+1);
            }else{
                map.put(c, 1);
            }
        }
        char maxChar = ' ';
        int max = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){

            if(entry.getValue() == max){
               maxChar = '?';
            } else if(entry.getValue() > max){
                max = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(maxChar);
        bw.close();
    }
}
