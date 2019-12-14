package CODETEST;
import java.io.*;
import java.util.*;

class NHN_Q1_Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] cardSplit = str.split(" ");
        Map<String, Integer> cards = new HashMap<>();

        for(String cs : cardSplit){
            if(cards.containsKey(cs)){
                cards.put(cs, cards.get(cs)+1);
            }else{
                cards.put(cs, 1);
            }
        }
        int max = 0;
        Map<Integer, Integer> values = new HashMap<>();

        for(Map.Entry<String,Integer> card : cards.entrySet()){
            if(values.containsKey(card.getValue())){
                values.put(card.getValue(), values.get(card.getValue())+1);
            }else{
                values.put(card.getValue(), 1);
            }
            max = Math.max(max, card.getValue());
        }
        boolean b = true;
        for(Map.Entry<Integer,Integer> value : values.entrySet()){
            if(value.getKey() != max){
                if(value.getValue() > values.get(max)){
                    b = false;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(b && values.size()<=2){
            bw.write("Y\n");
            if(values.size()>1){
                n += 1;
            }
        }else{
            bw.write("N\n");
        }
        bw.write(String.valueOf(n)+"\n");
        bw.write(String.valueOf(cards.size())+"\n");
        bw.close();
    }
}

public class NHN_Q1 {
}
